package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderCompletedPage {
    private WebDriver driver;
    public OrderCompletedPage(WebDriver driver) {
        this.driver = driver;
    }
    By message=By.xpath("//h2[@class='complete-header']");
    By sideMenu=By.id("react-burger-menu-btn");
    By logOut=By.id("logout_sidebar_link");
    public String getMessage(){
        return driver.findElement(message).getText();
    }
    public void openSideMenu(){
        driver.findElement(sideMenu).click();
    }
    public void clickLogOut(){
        driver.findElement(logOut).click();
    }
}
