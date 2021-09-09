package com.patricia.basics;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHolder {
    private static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<RemoteWebDriver>();
    private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();

    public static RemoteWebDriver getWebDriver() {
        return webDriver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void setWebDriver(RemoteWebDriver webDriver, int timeoutInSeconds) {
        WebDriverHolder.webDriver.set(webDriver);
        wait.set(new WebDriverWait(webDriver,timeoutInSeconds));
    }
}
