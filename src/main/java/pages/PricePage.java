package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PricePage {
    private WebDriver driver;
    public PricePage(WebDriver driver) {
        this.driver = driver;
    }
    By finishButton=By.id("finish");
    public OrderCompletedPage clickFinishButton(){
        driver.findElement(finishButton).click();
        return new OrderCompletedPage(driver);
    }
}
