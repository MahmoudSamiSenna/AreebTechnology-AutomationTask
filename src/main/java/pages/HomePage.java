package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By backPack=By.id("add-to-cart-sauce-labs-backpack");
    By boltTShirt=By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By redTShirt=By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By card=By.id("shopping_cart_container");
    public void addBackPackToCard(){
        driver.findElement(backPack).click();
    }
    public void addBoltTShirtToCard(){
        driver.findElement(boltTShirt).click();
    }
    public void addRedTShirt(){
        driver.findElement(redTShirt).click();
    }
    public CardPage clickCard(){
        driver.findElement(card).click();
        return new CardPage(driver);
    }
}
