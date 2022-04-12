package utils;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenHandler {
    
    public static void swipeuUp(AppiumDriver<MobileElement> appiumDriver){
        // Get mobile window size
        Dimension windownSize = appiumDriver.manage().window().getSize();
        int screenHeight = windownSize.getHeight();
        int screenWidth = windownSize.getWidth();
        
        //calculator touch point
        
    }
}
