package com.patricia.pages;

import com.patricia.basics.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends ProductPageLocators{

    public void clickOnBuyNowButton(){
        WebElement buyNowButton = WebDriverHolder
                .getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUY_NOW_BUTTON)));
        buyNowButton.click();
    }

}
