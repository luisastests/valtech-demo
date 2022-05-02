package PageObjects;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EShopLoginPage {

    private final DriverManager driverManager;

    public EShopLoginPage(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    private WebElement getUserNameField() {
        return driverManager.getDriver().findElement(By.id("Input_Email"));
    }

    private WebElement getPasswordField() {
        return driverManager.getDriver().findElement(By.id("Input_Password"));
    }

    private WebElement getLoginButton() {
        return driverManager.getDriver().findElement(By.cssSelector("button[class='btn btn-default'"));
    }

    public void setUserName(String userName) {
        getUserNameField().sendKeys(userName);
    }

    public void setPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickOnLogin() {
        getLoginButton().click();
    }
}