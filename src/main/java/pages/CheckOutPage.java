package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    private WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    By firstNameField=By.id("first-name");
    By lastNameField=By.id("last-name");
    By zipCodeField=By.id("postal-code");
    By continueButton=By.id("continue");
    public void enterFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void enterLAstName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void enterZipCode(String zipCode){
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }
    public PricePage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return new PricePage(driver);
    }
}
