package pageobject;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class GtListPage {

    AppiumDriver<MobileElement> driver;
    By customerMenu_tab = MobileBy.xpath("//android.widget.ImageView[contains(@content-desc,\"Khách hàng\")]");
    By all_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Tất cả\")]");
    By support_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Chăm sóc\")]");
    By potential_tab = MobileBy.xpath("//android.view.View[contains(@content-desc,\"Tiềm năng\")]");
    By search_it = MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Tìm kiếm tên GT, SĐT, địa chỉ\"]");
    By editSearch_it = MobileBy.xpath("//*[contains(@text, \"Tìm kiếm tên GT, SĐT, địa chỉ\")]");
    By cancelSearch_icon = MobileBy.xpath("//android.view.View[@content-desc=\"Huỷ\"]");
    By resultSearch_tf = MobileBy.xpath("//*[contains(@content-desc,\"Auto\")]");
    By confirm_btn = MobileBy.xpath("(//android.widget.Button[@content-desc=\"Xác minh\"])[1]");
    By route_lai_thuong_tf = MobileBy.xpath("//*[contains(@content-desc,\"X. Lại Thượng\")]");
    By route_di_nau_tf = MobileBy.xpath("//*[contains(@content-desc,\"X. Dị Nậu\")]");
    By filter_icon = MobileBy.xpath("//*[contains(@content-desc,\"Bộ lọc\")]");
    By clearAllFilter_btn = MobileBy.AccessibilityId("Bỏ hết");
    By applyFilter_btn = MobileBy.AccessibilityId("Áp dụng");
    By gtIsReported_tf = MobileBy.xpath("//*[contains(@content-desc,\"Đã báo cáo, đang chờ xét duyệt\")]");
    By gtIsVipStore_tf = MobileBy.xpath("//*[contains(@content-desc,\"Đủ điều kiện tham gia trưng bày\")]");

    public GtListPage(AppiumDriver<MobileElement> driver) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(customerMenu_tab).click();
        this.driver = driver;
    }

    public void clickAllTab() {
        driver.findElement(all_tab).click();
    }

    public void clickSupportTab() {
        driver.findElement(support_tab).click();
    }

    public void clickPotentialTab() {
        driver.findElement(potential_tab).click();
    }

    public void clickSearchGt() {
        driver.findElement(search_it).click();
    }

    public void sendKeySearchGt(String text) {
        driver.findElement(editSearch_it).sendKeys(text);
    }

    public void clickCanCelSearchGt() {
        driver.findElement(cancelSearch_icon).click();
    }

    public void clickCreateNewGt() {
        driver.findElement(cancelSearch_icon).click();
    }

    public Boolean testIsdisplay(String search_text) {
        By result_search_txt = MobileBy.xpath("//*[contains(@content-desc,\"" + search_text + "\")]");
        Boolean resul = driver.findElement(result_search_txt).isDisplayed();
        return resul;
    }

    public String getTextSearchGt(String search_text) {
        String result = "";
        MobileElement element = null;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        By result_search_txt = MobileBy.xpath("//*[contains(@content-desc,\"" + search_text + "\")]");
        try {
            element = driver.findElement(result_search_txt);
        } catch (Exception e) {
            System.out.println("Error happend with err: No such Element");
        }
        if (element != null) {
            result = element.getAttribute("content-desc");
        }
        return result;
    }

    public String getTextRoute(String route) {
        String result = null;
        try {
            if (route == "X. Lại Thượng") {
                result = driver.findElement(route_lai_thuong_tf).getAttribute("content-desc");
            }
            if (route == "X. Dị Nậu") {
                result = driver.findElement(route_di_nau_tf).getAttribute("content-desc");
            }
        } catch (Exception e) {
            return result;
        }
        return result;
    }

    public String verifyL0() {
        String result = driver.findElement(confirm_btn).getAttribute("content-desc");
        return result;
    }

    public boolean getGtIsReported() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String contentDesc = driver.findElement(gtIsReported_tf).getAttribute("content-desc");
            if (contentDesc != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean getGtIsVipStore() {
        try {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            String contentDesc = driver.findElement(gtIsVipStore_tf).getAttribute("content-desc");
            if (contentDesc != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // Filter
    public void navigateFilter() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(filter_icon).click();
    }

    public void clearAllFilter() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(clearAllFilter_btn).click();
    }

    public void applyFilter() {
        driver.findElement(applyFilter_btn).click();
    }

    public void selectFilterByRoute(String route) {
        By filterByRoute = MobileBy.AccessibilityId("" + route + "");
        driver.findElement(filterByRoute).click();
    }

    public void selectFilterGtReported() {
        By filterByRoute = MobileBy.AccessibilityId("Ẩn cửa hàng bạn đã báo cáo và đang chờ xét duyệt");
        driver.findElement(filterByRoute).click();
    }

    public void selectFilterVipStore() {
        By filterByRoute = MobileBy.AccessibilityId("Đủ điều kiện tham gia chương trình V.I.P");
        driver.findElement(filterByRoute).click();
    }

}
