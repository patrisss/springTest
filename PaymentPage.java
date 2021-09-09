package com.patricia.pages;

import com.patricia.basics.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
public class PaymentPage extends PaymentPageLocators{

    public void waitUntilPaymentFormIsLoaded(){
        WebDriverHolder
                .getWait()
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(CARD_FIELD_IFRAME_ID));
    }

    public void fillInPaymentForm(){
        waitUntilPaymentFormIsLoaded();
        fillInCardNumber();
    }

    public void fillInCardNumber(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(CARD_NUMBER_FIELD))
                .sendKeys("1234567890123");
    }
}
