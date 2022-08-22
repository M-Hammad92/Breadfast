import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;

public class Capabilities {

    public static void main(String[] args) throws MalformedURLException {

        /**
         * Passing apk Path
         * */
        File appDir = new File("src");
        File app = new File(appDir, "breadfast.apk");

        /**
         * Setting Up Capabilities
         * */
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "R3CR20ATNTN");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability("platformName", "android");
        cap.setCapability("appPackage", "com.breadfast");
        cap.setCapability("appActivity", "com.breadfast.MainActivity");
    }
}