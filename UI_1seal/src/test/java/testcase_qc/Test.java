package testcase_qc;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.HomeMenu;
import pageobject.Login;
import resource.Driver;

public class Test {
    static AppiumDriver<MobileElement> driver;
    public static void main(String[] args) throws Exception{
     AppiumDriver<MobileElement> driver = Driver.openApp();
     Login login = new Login(driver);
     login.loginByAccount();
    }
}
