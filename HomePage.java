package com.patricia.pages;

import com.patricia.basics.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends HomePageLocators {


    public void clickProduct() {
        WebElement productLink = WebDriverHolder
                .getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(PRODUCT)));
        productLink.click();
    }

}

