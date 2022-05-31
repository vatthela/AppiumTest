package testcase_uat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.GtListPage;
import pageobject.OnboardingPage;
import resource.Driver;

public class TC_OnboardingGT {
    AppiumDriver<MobileElement>  driver;
    @BeforeClass
    public AppiumDriver<MobileElement> navigateCustomerMenu() throws Exception{ 
        driver = Driver.openApp();
        GtListPage gtListPage = new GtListPage(driver);
        return driver;
    }

    //Onboarding GT
    @Test
    public void verifyOnboardGt(){
        OnboardingPage onboardingPage = new OnboardingPage(driver);
        
    }
}
