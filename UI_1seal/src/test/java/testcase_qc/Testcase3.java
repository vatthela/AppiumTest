package testcase_qc;
import resource.Driver;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.GtList;

public class Testcase3 {
    AppiumDriver<MobileElement> driver;
    //AppiumDriver<MobileElement> driver = null;
    GtList gtList = null;

    @BeforeTest  
    public void navigate_customer_menu() throws Exception{ 
        AppiumDriver<MobileElement> driver = Driver.openApp();
        gtList = new GtList(driver);
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
    @Test (priority = 1, dataProvider =  "text_search_customer_L1")
    public void verify_search_L1(String text_l1) throws Exception{
        gtList.clickSearchGt();
        gtList.sendKeySearchGt(text_l1);
        String actual = null;
        if (gtList.getTextSearchGt().contains(text_l1) == true) {
            actual = text_l1;  
            System.out.println(actual);
            Assert.assertEquals(actual , text_l1);
        }
        gtList.clickCanCelSearchGt();
    }

    //Test Search GT L0
    @Test (priority = 2, dataProvider =  "text_search_customer_L0")
    public void verify_search_L0(String text_l0) throws Exception{
        gtList.clickSearchGt();
        gtList.sendKeySearchGt(text_l0);
        String actual = null;
        if (gtList.getTextSearchGt().contains(text_l0) == true) {
            actual = text_l0; 
            System.out.println(actual);
            Assert.assertEquals(actual , text_l0); 
        }
        gtList.clickCanCelSearchGt();
    }

    //Test GT List

}
