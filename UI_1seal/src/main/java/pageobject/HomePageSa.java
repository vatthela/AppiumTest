package pageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HomePageSa {
    AppiumDriver<MobileElement> driver;
    By customerMenu_tab = MobileBy.xpath("//android.widget.ImageView[contains(@content-desc,\"Khách hàng\")]");
    By all_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Tất cả\")]");
    By support_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Chăm sóc\")]");
    By potential_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Tiềm năng\")]");
    By checkOut_btn = MobileBy.AccessibilityId("Check-out");
    
    public void nameAlo(String gtName) throws Exception {
        String xpath = "//android.widget.ImageView[contains(@content-desc,\""+ gtName +"\")]//android.view.View[contains(@content-desc,\"Check-in\")]";
/*         List<String> xpaths = new ArrayList<>();
        xpaths.add("//android.widget.ImageView[contains(@content-desc,\""+ gtName +"\")]");
        xpaths.add("//android.view.View[contains(@content-desc,\"Check-in\")]");
        String s = xpaths.stream().collect(Collectors.joining(","));
        System.out.println(s); */
        By checkIn_btn = MobileBy.xpath(xpath);
        
    }
}
