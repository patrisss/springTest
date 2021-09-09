package com.patricia.pages;

import com.patricia.basics.WebDriverHolder;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class DeliveryPage extends DeliveryPageLocators{
    public void fillInDeliveryForm(){
        log.info("Filling in delivery form");
        waitUntilDeliveryPageIsLoaded();
        fillInRandomPhoneNumber();
        fillInFirstName();
        fillInLastName();
        fillInAddress();
        fillInPostCode();
        fillInCiy();
        clickOnSaveButton();
    }

    public void clickToProceedToPayment(){
        log.info("Saving delivery data and proceeding to payment");
        WebDriverHolder.getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(PROCEED_TO_PAYMENT))).click();
    }

    public void waitUntilDeliveryPageIsLoaded(){
        log.info("Waiting for delivery form to be loaded");
        WebDriverHolder.getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dynamic-checkout__content")));
    }
    
    public void fillInRandomPhoneNumber(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(PHONE_NUMBER_FIELD))
                .sendKeys(generateRandomPhoneNumber());
    }

    public void fillInFirstName(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(FIRST_NAME_FIELD))
                .sendKeys("RandomFirstName");
    }

    public void fillInLastName(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(LAST_NAME_FIELD))
                .sendKeys("RandomLastName");
    }

    public void fillInAddress(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(SHIPPING_ADDRESS_FIELD))
                .sendKeys("Randomstr 16");
    }

    public void fillInPostCode(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(ZIP_CODE_FIELD))
                .sendKeys("10827");
    }

    public void fillInCiy(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(CITY_FIELD))
                .sendKeys("Berlin");
    }

    public void clickOnSaveButton(){
        log.info("Saving shipping details");
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(SAVE_SHIPPING_DETAILS_BUTTON))
                .click();
    }

    static Integer getRandomNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    static String generateRandomPhoneNumber(){
        String randomPart = "";
        int maxPhoneLength = 10;
        for(int i = 0; i < maxPhoneLength; i++){
            randomPart = randomPart + getRandomNumberBetween(0, 9);
        }
        return randomPart;
    }
}
