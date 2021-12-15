import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import com.google.android.gms.maps.GoogleMap;

public class ExploreActivity {

    AndroidDriver driver;

    MobileElement btnRandom;
    MobileElement btnLike;
    MobileElement btnFavorites;
    MobileElement btnSwitch;
    MobileElement textLabel;
    MobileElement btnBack;

    public ExploreActivity(AndroidDriver driver) {
        this.driver = driver;
        findElements();
    }

    private void findElements(){
        if (this.driver == null)
            return;

        this.btnRandom = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button[3]"));

        this.btnLike = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button[2]"));

        this.btnFavorites = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.Button[1]"));

        this.btnSwitch = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Switch"));

        this.textLabel = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView"));

        this.btnBack = (MobileElement)
                this.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    }

    public void clickOnButtonRandom(){
        this.btnRandom.click();
    }

    public void clickOnButtonLike(){
        this.btnLike.click();
    }

    public void clickOnButtonFavorites(){
        this.btnFavorites.click();
    }

    public void clickOnButtonSwitch(){
        this.btnSwitch.click();
    }

    public String getTextFromCityInfoTextLabel(){
        return this.textLabel.getText();
    }

    public void clickOnButtonBack(){
        /*
        *   Here is able to find element by xpath, but  navigate().back() method doesn't work
        * */
        this.btnBack.click();
        //this.driver.navigate().back();
    }

    public void getMarker() {
        
    }
}
