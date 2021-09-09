package com.patricia.SpringBasic;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
@Slf4j
class BaseWebTest {


    @BeforeTest
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    protected static final WebDriver driver = new ChromeDriver();

    @BeforeTest
    public static void openPage(){ driver.get(Utils.BASE_URL);
    }

    @AfterTest
    public static void closeBrowser(){
        driver.close();
    }
}
