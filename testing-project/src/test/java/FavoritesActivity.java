import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class FavoritesActivity {

    AndroidDriver driver;

    MobileElement recycler;
    MobileElement group;
    MobileElement textLabelCityName;
    MobileElement btnDelete;
    MobileElement btnBack;

    public FavoritesActivity(AndroidDriver driver) {
        this.driver = driver;
        findElements();
    }

    private void findElements() {
        if (this.driver == null)
            return;

        this.recycler = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout")); // brisi
/*
        this.group = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.RelativeLayout"));
*/
        this.textLabelCityName = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.TextView[1]"));

        this.btnDelete = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android." +
                        "widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.TextView[2]"));


        /*this.btnBack = (MobileElement)
                this.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));*/

        /*this.btnBack = (MobileElement)
                this.driver.findElement(By.className("android.widget.ImageButton"));*/
    }

    public String getCityName(){
        if (this.textLabelCityName == null)
            return "";
        return this.textLabelCityName.getText();
    }

    public void clickOnButtonDelete(){
        this.btnDelete.click();
        this.btnDelete = null;
        this.textLabelCityName = null;
    }

    public void clickOnButtonBack(){
        /*
        *   Ways of finding this "Navigate up"/"Back Button" change
        *   Same line of code sometimes is able and sometimes unable to get button reference
        * */
       this.btnBack = (MobileElement)
                this.driver.findElement(By.className("android.widget.ImageButton"));

        //this.btnBack.click();

        this.driver.navigate().back();
    }
}
