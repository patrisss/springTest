package com.patricia.tests;

import com.patricia.basics.BaseWebTest;
import com.patricia.pages.DeliveryPage;
import com.patricia.pages.HomePage;
import com.patricia.pages.PaymentPage;
import com.patricia.pages.ProductPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class Tests extends BaseWebTest {

    @Autowired
    private HomePage homePage;
    @Autowired
    private ProductPage productPage;
    @Autowired
    private DeliveryPage deliveryPage;
    @Autowired
    private PaymentPage paymentPage;

    @Test
    public void verifyFailedTransaction() {
        homePage.clickOnAcceptCookiesIfPresent();
        homePage.clickProduct();
        productPage.clickOnBuyNowButton();
        deliveryPage.fillInDeliveryForm();
        deliveryPage.clickToProceedToPayment();
        paymentPage.fillInPaymentForm();
    }
}
