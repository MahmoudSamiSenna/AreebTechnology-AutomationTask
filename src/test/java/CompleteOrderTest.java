import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class CompleteOrderTest extends BaseTest{
    private LoginPage loginPage;
    private HomePage homePage;
    private CardPage cardPage;
    private CheckOutPage checkOutPage;
    private PricePage pricePage;
    private OrderCompletedPage orderCompletedPage;
    @Test(priority = 1)
    public void login(){
        loginPage=new LoginPage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
    @Test(priority = 2, dependsOnMethods = "login")
    public void addItemToCard(){
        homePage=new HomePage(driver);
        homePage.addBackPackToCard();
        homePage.addBoltTShirtToCard();
        homePage.addRedTShirt();
        homePage.clickCard();
    }
    @Test(priority = 3,dependsOnMethods = "addItemToCard")
    public void getItemsName(){
        cardPage=new CardPage(driver);
        Assert.assertTrue(cardPage.getItem1Name().contains("Backpack"));
        Assert.assertTrue(cardPage.getItem2Name().contains("Bolt T-Shirt"));
        Assert.assertTrue(cardPage.getItem3Name().contains("T-Shirt (Red)"));
        System.out.println("Item 1 name is "+cardPage.getItem1Name());
        System.out.println("Item 2 name is "+cardPage.getItem2Name());
        System.out.println("Item 3 name is "+cardPage.getItem3Name());
        cardPage.clickCheckOutButton();
    }
    @Test(priority = 4,dependsOnMethods = "getItemsName")
    public void enterNameAndZipCode(){
        checkOutPage=new CheckOutPage(driver);
        checkOutPage.enterFirstName("Mahmoud");
        checkOutPage.enterLAstName("Sami");
        checkOutPage.enterZipCode("11655");
        checkOutPage.clickOnContinueButton();
    }
    @Test(priority = 5,dependsOnMethods ="enterNameAndZipCode")
    public void finishOrder(){
        pricePage=new PricePage(driver);
        pricePage.clickFinishButton();
    }
    @Test(priority = 6,dependsOnMethods = "finishOrder")
    public void logOut() throws InterruptedException {
        orderCompletedPage=new OrderCompletedPage(driver);
        Assert.assertTrue(orderCompletedPage.getMessage().contains("Thank you"));
        System.out.println(orderCompletedPage.getMessage());
        orderCompletedPage.openSideMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        orderCompletedPage.clickLogOut();
        Thread.sleep(1000);
    }
}
