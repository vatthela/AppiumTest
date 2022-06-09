package testcase_uat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.GtDetailPage;
import pageobject.GtListPage;
import resource.Driver;

public class TC_ProposalProduct {
    AppiumDriver<MobileElement> driver;
    GtListPage gtListPage;
    GtDetailPage gtDetailPage;

    @BeforeClass
    public void verifyProposalProduct() throws  Exception {
        driver = Driver.openApp();
    }

}
