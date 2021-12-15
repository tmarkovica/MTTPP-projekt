import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MainActivity {

    AndroidDriver driver;

    MobileElement btnFavorites;

    MobileElement btnExplore;

    public MainActivity(AndroidDriver driver) {
        this.driver = driver;
        findElements();
    }

    private void findElements(){
        if (this.driver == null)
            return;

        this.btnFavorites = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android." +
                        "view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[1]"));


        this.btnExplore = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android." +
                        "view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[2]"));
    }

    public void clickOnButtonFavorites(){
        /*this.btnFavorites = (MobileElement)
                this.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android." +
                        "view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.Button[1]"));*/

        this.btnFavorites.click();
    }

    public void clickOnButtonExplore(){
        this.btnExplore.click();
    }
}
