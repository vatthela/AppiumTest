package testcase_uat;
import resource.Driver;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.GtListPage;

public class TC_SearchGt {
    AppiumDriver<MobileElement> driver;
    //AppiumDriver<MobileElement> driver = null;
    GtListPage gtListPage = null;

    @BeforeClass
    public void init() throws Exception{ 
        AppiumDriver<MobileElement> driver = Driver.openApp();
        gtListPage = new GtListPage(driver);
    }

    @DataProvider(name = "text_search_customer_L1")
    public Object[][] data_L1(){
        return new Object[][] {{"0111770001"}};
    }

    @DataProvider(name = "text_search_customer_L0")
    public Object[][] data_L0(){
        return new Object[][] {{"0111770004"}};
    }
    
    //Test Search GT L1
    @Test (priority = 1, dataProvider = "text_search_customer_L1")
    public void verifySearchL1(String text_l1) throws Exception{
        gtListPage.clickSearchGt();
        gtListPage.sendKeySearchGt(text_l1);
        String actual = null;  
        if (gtListPage.getTextSearchGt(text_l1).contains(text_l1) == true) {
            actual = text_l1;
        }      
        try {
            Assert.assertEquals(actual , text_l1);
        } finally {
            System.out.println(actual);
            gtListPage.clickCanCelSearchGt();
        }  
    }

    //Test Search GT L0
    @Test (priority = 2, dataProvider = "text_search_customer_L0")
    public void verifySearchL0(String text_l0) throws Exception{
        gtListPage.clickSearchGt();
        gtListPage.sendKeySearchGt(text_l0);
        String actual = null;
        if (gtListPage.getTextSearchGt(text_l0).contains(text_l0) == true) {
            actual = text_l0; 
        }
        try {
            Assert.assertEquals(actual , text_l0);
            Assert.assertEquals(gtListPage.verifyL0(), "Xác minh");
        } finally{
            gtListPage.clickCanCelSearchGt();
            System.out.println(actual);
        }
    }
}
