package com.patricia.tests;

import com.patricia.basics.BaseWebTest;
import com.patricia.pages.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class Tests extends BaseWebTest {

    @Autowired
    private HomePage homePage;

    @Test
    public void verifyFailedTransaction() {

        homePage.clickProduct();

    }

}
