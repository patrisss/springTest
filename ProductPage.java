package com.patricia.pages;

import com.patricia.basics.WebDriverHolder;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductPage extends ProductPageLocators{

    public void clickOnBuyNowButton(){
        log.info("Clicking on buy now button");
        WebElement buyNowButton = WebDriverHolder
                .getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUY_NOW_BUTTON)));
        buyNowButton.click();
    }
}
