package com.patricia.pages;

import com.patricia.basics.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class HomePage extends HomePageLocators {


    public void clickProduct() {
        WebElement productLink = WebDriverHolder
                .getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(PRODUCT)));
        productLink.click();
    }

    public void clickOnAcceptCookiesIfPresent() {
        if (exists()) {
            WebElement acceptCookiesButton = WebDriverHolder
                    .getWait()
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(ACCEPT_COOKIES_BANNER)));
            acceptCookiesButton.click();
        }
    }

    public static boolean exists() {
        return WebDriverHolder.getWebDriver().findElement(By.cssSelector(ACCEPT_COOKIES_BUTTON)) != null;
    }

    public void clickOnBuyNowButton(){
        WebElement buyNowButton = WebDriverHolder
                .getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUY_NOW_BUTTON)));
        buyNowButton.click();
    }

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
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#continue_button"))).click();
    }

    public void fillInPaymentForm(){
        waitUntilPaymentFormIsLoaded();

        fillInCardNumber();
    }

    public void waitUntilPaymentFormIsLoaded(){
        WebDriverHolder
                .getWait()
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("[id*='card-fields-number']"));
    }
    public void waitUntilDeliveryPageIsLoaded(){
                WebDriverHolder.getWait()
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dynamic-checkout__content")));
    }

    public void fillInPhoneNumber(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("input[data-email-or-phone-input]"))
                .sendKeys("17675899935");

    }

    public void fillInRandomPhoneNumber(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("input[data-email-or-phone-input]"))
                .sendKeys(generateRandomPhoneNumber());

    }

    public void fillInFirstName(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("#checkout_shipping_address_first_name"))
                .sendKeys("RandomFirstName");
    }
    public void fillInLastName(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("#checkout_shipping_address_last_name"))
                .sendKeys("RandomLastName");
    }

    public void fillInAddress(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("#checkout_shipping_address_address1"))
                .sendKeys("Randomstr 16");
    }

    public void fillInPostCode(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("#checkout_shipping_address_zip"))
                .sendKeys("10827");
    }

    public void fillInCiy(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("#checkout_shipping_address_city"))
                .sendKeys("Berlin");
    }

    public void clickOnSaveButton(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("#continue_button"))
                .click();
    }

    public void fillInCardNumber(){
        WebDriverHolder.getWebDriver()
                .findElement(By.cssSelector("#number"))
                .sendKeys("1234567890123");
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

