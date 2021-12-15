//TestMobile.java
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMobile {

    AndroidDriver driver;

    @BeforeClass()
    public void setUp() throws MalformedURLException{
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Users\\Tomislav\\AppData\\Local\\Android\\Sdk\\platform-tools\\app-release.apk");
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName","emulator");
        capabilities.setCapability("platformName","Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    static final String strCase1 = "Randomize to get city!";
    static final String strCase2 = "Request not yet processed";

    @Test
    public void randomizerTestOld() throws Exception {
        MobileElement btnExplore = (MobileElement)
                driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android." +
                        "view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[2]"));
        btnExplore.click();

        MobileElement btnRandom = (MobileElement)
                driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android." +
                        "view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button[3]"));

        MobileElement textView = (MobileElement)
                driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android." +
                        "view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView"));

        String temp = "";
        int count = 0;

        do {
            btnRandom.click();
            Thread.sleep(1000);
            temp = textView.getText();
            count++;
            if (count >= 10){
             Assert.assertTrue(false, "Unable to find city");
             return;
            }
        } while (temp == strCase1 || temp == strCase2);

        Assert.assertTrue(true, "Number of randomizes: " + count);
    }

    @Test
    public void likeTest() throws Exception {

    }

    public void teardown(){
        driver.quit();
    }
}
