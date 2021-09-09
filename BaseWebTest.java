package com.patricia.basics;

import com.patricia.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


@Slf4j
@ContextConfiguration(classes = Config.class)
public class BaseWebTest extends AbstractTestNGSpringContextTests {

    @Value("${browser}")
    private String browser;
    @Value("${url}")
    private String url;
    @Value("${timeout}")
    private Integer timeout;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        WebDriverHolder.setWebDriver(BrowserFactory.getBrowser(browser),timeout);
        WebDriverHolder.getWebDriver().navigate().to(url);
    }

    @AfterTest(alwaysRun = true)
    public static void closeBrowser() {
        WebDriverHolder.getWebDriver().close();
    }
}
