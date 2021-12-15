import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRunner {
    String path = "C:\\Users\\Tomislav\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-release.apk";
    AndroidDriver driver;

    ExploreActivity exploreActivity;
    FavoritesActivity favoritesActivity;
    MainActivity mainActivity;

    @BeforeClass
    public void setup() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", this.path);
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName","emulator");
        capabilities.setCapability("platformName","Android");
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    static final String strCase1 = "Randomize to get city!";
    static final String strCase2 = "Request not yet processed";

    public String findRandomCity() throws InterruptedException {
        this.mainActivity = new MainActivity(this.driver);
        this.mainActivity.clickOnButtonExplore();

        this.exploreActivity = new ExploreActivity(this.driver);

        int count = 0;
        String info;
        do {
            Thread.sleep(1000); // free API allows 1 call/second
            this.exploreActivity.clickOnButtonRandom();
            info = this.exploreActivity.getTextFromCityInfoTextLabel();
            count++;
            if (count > 10){
                return "";
            }
        } while (info.equals(strCase1) || info.equals(strCase2)); // while (temp == strCase1 || temp == strCase2);
        return info;
    }

    @Test
    public void buttonRandomTest() throws Exception {
        this.mainActivity = new MainActivity(this.driver);
        this.mainActivity.clickOnButtonExplore();

        this.exploreActivity = new ExploreActivity(this.driver);

        int count = 0;
        String info;
        do {
            Thread.sleep(1000);
            this.exploreActivity.clickOnButtonRandom();
            info = this.exploreActivity.getTextFromCityInfoTextLabel();
            count++;
            if (count > 10){
                Assert.fail("Unable to find city");
                return;
            }
        } while (info.equals(strCase1) || info.equals(strCase2)); // while (temp == strCase1 || temp == strCase2);

        Assert.assertTrue(true);
    }

    public String getCurrentActivity() throws Throwable {
        String temp = this.driver.currentActivity();
        return !temp.equals("") ? temp : "0";
    }

    @Test
    public void cycleActivities_Main_Explore_Favorites() throws Throwable {
        this.mainActivity = new MainActivity(this.driver);
        this.mainActivity.clickOnButtonExplore();

        this.exploreActivity = new ExploreActivity(this.driver);
        if (getCurrentActivity().equals(".ExploreActivity") == false)
            Assert.fail();
        this.exploreActivity.clickOnButtonFavorites();

        this.favoritesActivity = new FavoritesActivity(this.driver);
        if (getCurrentActivity().equals(".FavoritesActivity") == false)
            Assert.fail();
        this.favoritesActivity.clickOnButtonBack();
        if (getCurrentActivity().equals(".ExploreActivity") == false)
            Assert.fail();
        this.exploreActivity.clickOnButtonBack();

        Assert.assertEquals(getCurrentActivity(),".MainActivity");
    }

    @Test
    public void cycleActivities_Main_Favorites() throws Throwable {
        this.mainActivity = new MainActivity(this.driver);
        this.mainActivity.clickOnButtonFavorites();
        this.favoritesActivity = new FavoritesActivity(this.driver);
        if (getCurrentActivity().equals(".FavoritesActivity") == false)
            Assert.fail();
        this.favoritesActivity.clickOnButtonBack();
        Assert.assertEquals(getCurrentActivity(),".MainActivity", getCurrentActivity());
    }

    @Test
    public void addingCityToFavorites() throws Throwable {
        this.mainActivity = new MainActivity(this.driver);
        this.mainActivity.clickOnButtonExplore();

        this.exploreActivity = new ExploreActivity(this.driver);

        int count = 0;
        String info;
        do {
            Thread.sleep(1000);
            this.exploreActivity.clickOnButtonRandom();
            info = this.exploreActivity.getTextFromCityInfoTextLabel();
            count++;
            if (count > 10){
                Assert.fail("Unable to find city");
                return;
            }
        } while (info.equals(strCase1) || info.equals(strCase2));

        this.exploreActivity.clickOnButtonLike();
        this.exploreActivity.clickOnButtonFavorites();

        this.favoritesActivity = new FavoritesActivity(this.driver);
        Assert.assertTrue(info.contains(this.favoritesActivity.getCityName()));
    }

    @Test
    public void addingCityToFavorites2() throws Throwable {
        String info = findRandomCity();
        if (info.equals(""))
            Assert.fail();

        this.exploreActivity.clickOnButtonLike();
        this.exploreActivity.clickOnButtonFavorites();

        this.favoritesActivity = new FavoritesActivity(this.driver);
        Assert.assertTrue(info.contains(this.favoritesActivity.getCityName()));
    }

    @Test
    public void removeCityFromFavorites() throws Throwable {
        String info = findRandomCity();
        if (info.equals(""))
            Assert.fail();

        this.exploreActivity.clickOnButtonLike();
        this.exploreActivity.clickOnButtonFavorites();

        this.favoritesActivity = new FavoritesActivity(this.driver);
        this.favoritesActivity.clickOnButtonDelete();

        Assert.assertTrue(this.favoritesActivity.getCityName().equals(""));
    }

    @Test
    public void markerCoordinatesTest() throws Throwable {
        String info = findRandomCity();
        if (info.equals(""))
            Assert.fail();

        String latitude = "0";
        String longitude = "0";

        Scanner scanner = new Scanner(info);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("latitude:"))
                latitude = line;
            if (line.contains("longitude:"))
                longitude = line;
        }
        scanner.close();

        float lati, longi = 0;

        latitude = latitude.replace("latitude: ", "");
        longitude = longitude.replace("longitude: ", "");

        lati = Float.parseFloat(latitude);
        longi = Float.parseFloat(longitude);

        this.exploreActivity.clickOnButtonSwitch();


    }
}
