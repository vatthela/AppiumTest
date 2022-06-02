package testcase_test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import pageobject.GtListPage;
import pageobject.HomeMenuPage;
import pageobject.LoginPage;
import resource.Driver;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    AppiumDriver<MobileElement> driver;
    GtListPage gtListPage = null;

    @BeforeClass
    public AppiumDriver<MobileElement> navigateCustomerMenu() throws Exception{ 
        AppiumDriver<MobileElement> driver = Driver.openApp();
        gtListPage = new GtListPage(driver);
        return driver;
    }
    @Test
    public void verifySearchL1() throws Exception{
        String text_l1 = "0111770001";
        gtListPage.clickSearchGt();
        gtListPage.sendKeySearchGt(text_l1);
        String actual = null;
        if (gtListPage.testIsdisplay(text_l1) == true) {
            actual = text_l1;
        }     
        boolean actual1 = gtListPage.testIsdisplay(text_l1);
        try {
            Assert.assertEquals(actual1 , true);
        } finally {
            System.out.println(actual);
            gtListPage.clickCanCelSearchGt();
        }  
    }
}
