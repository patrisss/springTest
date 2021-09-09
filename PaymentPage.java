package com.patricia.pages;

import com.patricia.basics.WebDriverHolder;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentPage extends PaymentPageLocators{

    public void waitUntilPaymentFormIsLoaded(){
        log.info("Waiting for payment iframe to laod");
        WebDriverHolder
                .getWait()
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(CARD_FIELD_IFRAME_ID));
    }

    public void fillInPaymentForm(){
        log.info("Filling in payment data");
        waitUntilPaymentFormIsLoaded();
        fillInCardNumber();
    }

    public void fillInCardNumber(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(CARD_NUMBER_FIELD))
                .sendKeys("1234567890123");
    }
}
