package PageObjects;

import drivers.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EShopBasketPage {

    private final DriverManager driverManager;

    public EShopBasketPage(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    private WebElement getCheckoutButton() {
        return driverManager.getDriver().findElement(By.xpath("*//input[@value='[ Checkout ]']"));
    }

    private WebElement getShirtRow(String itemName) {
        return driverManager.getDriver().findElement(By.xpath(String.format("*//section[text()='%s']", itemName)));
    }

    public void clickOnCheckout() {
        getCheckoutButton().click();
    }

    public void verifyItemList(String itemName) {
        Assert.assertNotNull(getShirtRow(itemName).getText());
    }

}