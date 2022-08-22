import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class test extends Capabilities {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities cap = new DesiredCapabilities();
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url,cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /**
         * Scrolling Down To Category Tile
         * Ex: Cold Drinks
         * */
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Cold Drinks\"))"
        ));

        /**
         * Initializing Locators Variables
         * Steps of Adding a Product to The Cart
         * Validating the Product is Added to the Cart
         * */

        MobileElement Cold_Drinks = driver.findElement(By.xpath("//*[@text='Cold Drinks']"));
        Cold_Drinks.click();

        MobileElement Add_To_Cart = driver.findElement(By.xpath("//*[@text='Add to cart']"));
        Add_To_Cart.click();

        MobileElement Cart_Icon = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"CartImgView\"]/android.view.ViewGroup/android.widget.ImageView"));
        Cart_Icon.click();

        MobileElement Product_Name = driver.findElement(By.xpath("//*[@text='Iced Americano (16oz)']"));
        MobileElement Checkout_CTA = driver.findElement(By.xpath("//*[@text='Go to Checkout']"));

        Assert.assertEquals(Product_Name.getText(), "Iced Americano (16oz)");
        Assert.assertEquals(Checkout_CTA.getText(), "Go to Checkout");

    }
}