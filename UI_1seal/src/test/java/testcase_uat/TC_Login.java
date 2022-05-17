package testcase_uat;

import resource.Driver;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.HomeMenu;
import pageobject.Login;

public class TC_Login {
     static AppiumDriver<MobileElement> driver;

     @Test
     public void verifyLogin() throws Exception{
          AppiumDriver<MobileElement> driver = Driver.openApp();
          Login login = new Login(driver);
          login.loginByAccount();
          Thread.sleep(3000);
          HomeMenu homemenu = new HomeMenu(driver);
          Assert.assertEquals(homemenu.getNameSa() , "Auto SA btl61");
          System.out.println(homemenu.getNameSa());
          homemenu.clickBack();
     }
}

