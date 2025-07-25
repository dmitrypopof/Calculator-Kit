package com.application.setting;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private AppiumDriver driver;

    public AppiumDriver setUp(Platform platform) throws MalformedURLException {
        return switch (platform){
            case IOS -> createIOSDriver();
            case ANDROID -> createAndroidDriver();
            default -> throw new IllegalArgumentException("No such platform");
        };
    }


    public AppiumDriver createAndroidDriver() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723");
        BaseOptions options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("appium:automationName", "UiAutomator2")
                .amend("appium:deviceName", "emulator-5554")
                .amend("appium:udid", "emulator-5554")
                .amend("appium:no_reset", true)
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 3600)
                .amend("appium:connectHardwareKeyboard", true);
        driver = new AndroidDriver(url,options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public AppiumDriver createIOSDriver(){
        return null;
    }
}
