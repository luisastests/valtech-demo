package PageObjects;

import drivers.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EShopHomePage {

    private final DriverManager driverManager;

    public EShopHomePage(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    public void goToHomePage() {
        driverManager.getDriver().navigate().to("https://eshop-onweb-webinar-demo2.azurewebsites.net/");
    }

    private WebElement getLoginButton() {
        return driverManager.getDriver().findElement(By.cssSelector("a[class='esh-identity-name esh-identity-name--upper'"));
    }

    private WebElement getAddToBasketByItemName(String itemName) {
        return driverManager.getDriver().findElement(By.xpath(String.format("//span[text()='%s']//parent::div//preceding-sibling::input", itemName)));
    }

    private WebElement getUserEmail() {
        return driverManager.getDriver().findElement(By.className("esh-identity-name"));
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public void clickOnAddToBasketByItemName(String itemName) {
        getAddToBasketByItemName(itemName).click();
    }

    public void verifyLoggedUser(String user) {
        Assert.assertEquals(user, getUserEmail().getText());
    }

}