package testcase_uat;

import org.apache.tools.ant.taskdefs.condition.And;
import org.aspectj.lang.annotation.After;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import pageobject.GtListPage;
import io.appium.java_client.AppiumDriver;
import resource.Driver;


public class TC_ListGt {
    GtListPage gtList;
    @BeforeClass
    public void navigateCustomerMenu() throws Exception{ 
        AppiumDriver<MobileElement> driver = Driver.openApp();
        gtList = new GtListPage(driver);
    }

    @Test ()
    public void verifyAllTab() throws Exception{
        String route = "X. Lại Thượng";
        String actual ="";
        gtList.clickAllTab();
        if (gtList.getTextRoute(route).contains(route) == true) {
            actual = route;
        }
        try {
            Assert.assertEquals(actual , "X. Dị Nậu");
        } finally {
            System.out.println(actual);
        } 
    }
    @Test ()
    public void verifySupportTab() throws Exception{
        String route = "X. Dị Nậu";
        String actual ="";
        gtList.clickSupportTab();
        if (gtList.getTextRoute(route).contains(route) == true) {
            actual = route;
        }
        try {
            Assert.assertEquals(actual , "X. Dị Nậu");
        } finally {
            System.out.println(actual);
        }   
    }
    
    @Test ()
    public void verifyPotentialTab() throws Exception{
        String route = "X. Dị Nâu";
        String gt_name = "0111770005";
        String actual ="";
        gtList.clickPotentialTab();
        if (gtList.getTextRoute(route).contains(route) == true && gtList.getTextSearchGt(gt_name).contains(gt_name) == true ) {
            actual = gt_name;
        }
        try {
            Assert.assertEquals(actual , gt_name);
            Assert.assertEquals(gtList.verifyL0(), "Xác minh");
        } finally{
            System.out.println(actual);
        }
    }
    }
    
}
