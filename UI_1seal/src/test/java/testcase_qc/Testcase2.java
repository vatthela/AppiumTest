package testcase_qc;

import resource.Driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.HomeMenu;
import org.testng.Assert;

public class Testcase2 {
    static AppiumDriver<MobileElement> driver;
    public static void main(String[] args) throws Exception{
        AppiumDriver<MobileElement> driver = Driver.openApp();
        Thread.sleep(10000);
        HomeMenu homemenu = new HomeMenu(driver);
        homemenu.movePolicy();
        Thread.sleep(3000);
        String name_of_policy = homemenu.getTextPolicy();
        Assert.assertEquals(name_of_policy, "Chính sách bán hàng tháng 4");
    }
}
