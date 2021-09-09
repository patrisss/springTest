package com.patricia.pages;

import com.patricia.basics.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DeliveryPage extends DeliveryPageLocators{
    public void fillInDeliveryForm(){
        waitUntilDeliveryPageIsLoaded();
        fillInPhoneNumber();
//        fillInRandomPhoneNumber();
        fillInFirstName();
        fillInLastName();
        fillInAddress();
        fillInPostCode();
        fillInCiy();
        clickOnSaveButton();
    }

    public void clickToProceedToPayment(){
        WebDriverHolder.getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(PROCEED_TO_PAYMENT))).click();
    }



    public void waitUntilDeliveryPageIsLoaded(){
        WebDriverHolder.getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dynamic-checkout__content")));
    }

    public void fillInPhoneNumber(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(PHONE_NUMBER_FIELD))
                .sendKeys("17675899935");

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
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector(SAVE_SHIPPING_DETAILS_BUTTON))
                .click();
    }

    static Integer getRandomNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    static String generateRandomPhoneNumber(){
        String phoneNumber = "";
        String randomPart = "";
        int maxPhoneLength = 11;
        for(int i = 0; i < maxPhoneLength; i++){
            randomPart = randomPart + getRandomNumberBetween(0, 9);
        }
        return phoneNumber;
    }
}
