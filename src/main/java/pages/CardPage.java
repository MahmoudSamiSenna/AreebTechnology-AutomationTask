package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardPage {
    private WebDriver driver;
    public CardPage(WebDriver driver) {
        this.driver = driver;
    }
    By backPack=By.id("item_4_title_link");
    By boltTShirt=By.id("item_1_title_link");
    By redTShirt=By.id("item_3_title_link");
    By checkOutButton=By.id("checkout");
    public String getItem1Name(){
        return driver.findElement(backPack).getText();
    }
    public String getItem2Name(){
        return driver.findElement(boltTShirt).getText();
    }
    public String getItem3Name(){
        return driver.findElement(redTShirt).getText();
    }
    public CheckOutPage clickCheckOutButton(){
        driver.findElement(checkOutButton).click();
        return new CheckOutPage(driver);
    }
}
