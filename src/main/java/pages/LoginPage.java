package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By userNameField=By.id("user-name");
    By passWordField=By.id("password");
    By loginButton=By.id("login-button");
    public void enterUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void enterPassword(String passWord){
        driver.findElement(passWordField).sendKeys(passWord);
    }
    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
