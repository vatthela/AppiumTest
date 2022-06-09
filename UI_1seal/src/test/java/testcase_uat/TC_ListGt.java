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
    GtListPage gtListPage;
    @BeforeClass
    public void init() throws Exception{ 
        AppiumDriver<MobileElement> driver = Driver.openApp();
        gtListPage = new GtListPage(driver);
    }

    @Test (priority = 1)
    public void verifyAllTab() throws Exception{
        String route = "X. Lại Thượng";
        String actual ="";
        gtListPage.clickAllTab();
        if (gtListPage.getTextRoute(route).contains(route) == true) {
            actual = route;
        }
        try {
            Assert.assertEquals(actual , "X. Dị Nậu");
        } finally {
            System.out.println(actual);
        } 
    }
    @Test (priority = 2)
    public void verifySupportTab() throws Exception{
        String route = "X. Dị Nậu";
        String actual ="";
        gtListPage.clickSupportTab();
        if (gtListPage.getTextRoute(route).contains(route) == true) {
            actual = route;
        }
        try {
            Assert.assertEquals(actual , "X. Dị Nậu");
        } finally {
            System.out.println(actual);
        }   
    }
    
    @Test (priority = 3)
    public void verifyPotentialTab() throws Exception{
        String route = "X. Dị Nâu";
        String gt_name = "0111770005";
        String actual ="";
        gtListPage.clickPotentialTab();
        if (gtListPage.getTextRoute(route).contains(route) == true && gtListPage.getTextSearchGt(gt_name).contains(gt_name) == true ) {
            actual = gt_name;
        }
        try {
            Assert.assertEquals(actual , gt_name);
            Assert.assertEquals(gtListPage.verifyL0(), "Xác minh");
        } finally{
            System.out.println(actual);
        }
        Driver.clearDrive();
    }   
}
