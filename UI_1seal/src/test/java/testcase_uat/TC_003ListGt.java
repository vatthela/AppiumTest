package testcase_uat;

import org.apache.tools.ant.taskdefs.condition.And;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import pageobject.GtListPage;
import io.appium.java_client.AppiumDriver;
import resource.Driver;


public class TC_003ListGt {
    GtListPage gtList;

    @BeforeClass
    public void navigateCustomerMenu() throws Exception{ 
        AppiumDriver<MobileElement> driver = Driver.openApp();
        gtList = new GtListPage(driver);
    }

    @Test ()
    public void verifyAllTab() throws Exception{
        String route = "X. Lại Thượng";
        gtList.clickAllTab();
        if (gtList.getTextRoute(route).contains(route) == true) {
            System.out.println(route);
        }
    }
    @Test ()
    public void verifySupportTab() throws Exception{
        String route = "X. Dị Nậu";
        gtList.clickSupportTab();
        if (gtList.getTextRoute(route).contains(route) == true) {
            System.out.println(route);
        }
    }
    /*
    @Test ()
    public void verifyPotentialTab() throws Exception{
        String route = "X. Dị Nâu";
        String gt_name = "0111770005";
        gtList.clickPotentialTab();
        if (gtList.getTextRoute(route).contains(route) == true && gtList.getTextSearchGt().contains(gt_name) == true ) {
            System.out.println(gtList.getTextSearchGt());
        }
    }
    */
}
