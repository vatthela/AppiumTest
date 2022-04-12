package testcase_qc;

import resource.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.Login;

public class Testcase1 {

    static AppiumDriver<MobileElement> driver ;

  
     public static void main(String[] args) throws Exception{
        driver = Driver.openApp();
        Login login = new Login(driver);
        login.loginByAccount();
     }
}
