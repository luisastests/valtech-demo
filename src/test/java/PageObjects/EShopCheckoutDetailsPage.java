package PageObjects;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EShopCheckoutDetailsPage {

    private static final String STREET = "Street 123";
    private static final String CITY = "City 123";
    private static final String STATE = "State 123";
    private static final String COUNTRY = "Country 123";
    private static final String ZIPCODE = "123456789";
    private static final String BRAND = "visa";
    private static final String CARD_NUMBER = "1234123412341234";
    private static final String CARD_HOLDER_NAME = "Card Holder Name 123";
    private static final String EXPIRATION_MONTH = "5";
    private static final String EXPIRATION_YEAR = "2024";
    private static final String CVC = "123";

    private final DriverManager driverManager;

    public EShopCheckoutDetailsPage(DriverManager driverManager) {
        this.driverManager = driverManager;
    }
    private WebElement getStreetField() {
        return driverManager.getDriver().findElement(By.id("ShippingAddress_Street"));
    }

    private WebElement getCityField() {
        return driverManager.getDriver().findElement(By.id("ShippingAddress_City"));
    }

    private WebElement getStateField() {
        return driverManager.getDriver().findElement(By.id("ShippingAddress_State"));
    }

    private WebElement getCountryField() {
        return driverManager.getDriver().findElement(By.id("ShippingAddress_Country"));
    }

    private WebElement getZipCodeField() {
        return driverManager.getDriver().findElement(By.id("ShippingAddress_ZipCode"));
    }

    private WebElement getBrandField() {
        return driverManager.getDriver().findElement(By.id("PaymentDetails_Brand"));
    }

    private WebElement getCardNumberField() {
        return driverManager.getDriver().findElement(By.id("PaymentDetails_CardNumber"));
    }

    private WebElement getCardHolderNameField() {
        return driverManager.getDriver().findElement(By.id("PaymentDetails_CardHolderName"));
    }

    private WebElement getExpirationMonthField() {
        return driverManager.getDriver().findElement(By.id("PaymentDetails_ExperationMonth"));
    }

    private WebElement getExpirationYearField() {
        return driverManager.getDriver().findElement(By.id("PaymentDetails_ExperationYear"));
    }

    private WebElement getCvcField() {
        return driverManager.getDriver().findElement(By.id("PaymentDetails_CVC"));
    }

    private WebElement getCompletePurchaseButton() {
        return driverManager.getDriver().findElement(By.xpath("*//button[text()='[ Complete Purchase ]']"));
    }

    public void fillCheckoutInfo() {
        getStreetField().sendKeys(STREET);
        getCityField().sendKeys(CITY);
        getStateField().sendKeys(STATE);
        getCountryField().sendKeys(COUNTRY);
        getZipCodeField().sendKeys(ZIPCODE);
        Select selectBrand = new Select(getBrandField());
        selectBrand.selectByValue(BRAND);
        getCardNumberField().sendKeys(CARD_NUMBER);
        getCardHolderNameField().sendKeys(CARD_HOLDER_NAME);
        getExpirationMonthField().sendKeys(EXPIRATION_MONTH);
        getExpirationYearField().sendKeys(EXPIRATION_YEAR);
        getCvcField().sendKeys(CVC);

    }
    public void clickOnCompletePurchase() {
        getCompletePurchaseButton().click();
    }
}