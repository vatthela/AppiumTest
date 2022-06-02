package testcase_test;

import resource.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.HomeMenuPage;
import pageobject.LoginPage;

public class Testcase1 {
     static AppiumDriver<MobileElement> driver;
     public static void main(String[] args) throws Exception{
          AppiumDriver<MobileElement> driver = Driver.openApp();
          LoginPage login = new LoginPage(driver);
          login.loginByAccount();
          Thread.sleep(10000);
          HomeMenuPage homemenu = new HomeMenuPage(driver);
          homemenu.moveLogout();
          Thread.sleep(3000);
          homemenu.clickLogout();
     }
}
