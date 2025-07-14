package com.application;

import com.application.setting.DriverFactory;
import com.application.setting.Platform;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;

public class TestBase {
    public AppiumDriver driver;

    private DriverFactory driverFactory = new DriverFactory();

    @BeforeEach
    public void setDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
    }

    @AfterEach
    public void tearDown() {
        //driver.terminateApp("ru.mvm.eldo");
        driver.quit();
    }

}
