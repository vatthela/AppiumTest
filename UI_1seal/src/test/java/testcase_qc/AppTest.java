package testcase_qc;

import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageobject.HomeMenuPage;
import resource.Driver;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public  void shouldAnswerWithTrue() throws Exception
    {   
        AppiumDriver<MobileElement> driver = Driver.openApp();

        HomeMenuPage login = new HomeMenuPage(driver);
        login.moveInfo();
    }
}
