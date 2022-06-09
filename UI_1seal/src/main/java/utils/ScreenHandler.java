package utils;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScreenHandler {

    // Parameter is % touch point Y  at screen
    public static void swipeuUp(AppiumDriver<MobileElement> driver, int StartPoint, int EndPoint) {
        // Get mobile window size
        Dimension windownSize = driver.manage().window().getSize();
        int screenHeight = windownSize.getHeight();
        int screenWidth = windownSize.getWidth();

        // calculator touch point
        int xStartPoint = 50 * screenWidth / 100;
        int yStartPoint = StartPoint * screenHeight / 100;
        int xEndPoint = 50 * screenWidth / 100;
        int yEndPoint = EndPoint * screenHeight / 100;

        // Convert to PointOpstions - Coordinates

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        // Perform Touch actions
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2))).moveTo(endPoint)
                .release().perform();
    }

    // Parameter is % Y point at screen
    public static void swipeuDown(AppiumDriver<MobileElement> driver, int StartPoint, int EndPoint) {
        // Get mobile window size
        Dimension windownSize = driver.manage().window().getSize();
        int screenHeight = windownSize.getHeight();
        int screenWidth = windownSize.getWidth();

        // calculator touch point
        int xStartPoint = 50 * screenWidth / 100;
        int yStartPoint = StartPoint * screenHeight / 100;
        int xEndPoint = 50 * screenWidth / 100;
        int yEndPoint = EndPoint * screenHeight / 100;

        // Convert to PointOpstions - Coordinates

        PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

        // Perform Touch actions
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(startPoint).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(2))).moveTo(endPoint)
                .release().perform();
    }

}
