package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static AndroidDriver driver;

    public void setup() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setApp(System.getProperty("user.dir") + "/apps/mda.apk")
                .setNoReset(true);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
