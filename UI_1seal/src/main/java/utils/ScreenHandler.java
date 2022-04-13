package utils;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScreenHandler {
    
    public static void swipeuUp(AppiumDriver<MobileElement> appiumDriver){
        // Get mobile window size
        Dimension windownSize = appiumDriver.manage().window().getSize();
        int screenHeight = windownSize.getHeight();
        int screenWidth = windownSize.getWidth();
        
        //calculator touch point
        int xStartPoint = 50 * screenHeight/100;
        int xEndPoint = xStartPoint;
        int yStartPoint = 50 * screenWidth/100;
        int yEndPoint = 50 * screenWidth/100;

        //Convert to PointOpstions - Coordinates
        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        //Perform Touch actions
        TouchAction touchAction = new TouchAction(appiumDriver);
        
        touchAction.press(endPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1))).moveTo(startPoint).release().perform();
    }
}
