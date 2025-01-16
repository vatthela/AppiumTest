package testcase_uat;

import resource.Driver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageobject.GtListPage;
import pageobject.HomeMenuPage;
import pageobject.LoginPage;

public class TC_Login {
     static AppiumDriver<MobileElement> driver;
     
     @Test
     public void verifyLogin() throws Exception{
          AppiumDriver<MobileElement> driver = Driver.openApp();
          LoginPage login = new LoginPage(driver);
          login.loginByAccount();
          Thread.sleep(3000);
          HomeMenuPage homemenu = new HomeMenuPage(driver);
          Assert.assertEquals(homemenu.getNameSa() , "Auto SA btl61");
          System.out.println(homemenu.getNameSa());
          homemenu.clickBack();
     }
}
