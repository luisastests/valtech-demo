import PageObjects.EShopBasketPage;
import PageObjects.EShopCheckoutDetailsPage;
import PageObjects.EShopHomePage;
import PageObjects.EShopLoginPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.DriverFactory;
import drivers.DriverManager;
import org.junit.Assert;

public class StepDefinitions {

    private final static String USERNAME = "demouser@microsoft.com";
    private final static String PASSWORD = "Pass@word1";
    private final static String ITEM_TO_BUY = ".NET Bot Black Sweatshirt";
    private final static String LOGIN_URL = "https://eshop-onweb-webinar-demo2.azurewebsites.net/Identity/Account/Login";
    private final static String BASKET_URL = "https://eshop-onweb-webinar-demo2.azurewebsites.net/Basket";
    private final static String CHECKOUT_FORM_URL = "https://eshop-onweb-webinar-demo2.azurewebsites.net/Basket/CheckoutForm";
    private final static String  CONFIRM_CHECKOUT_URL = "https://eshop-onweb-webinar-demo2.azurewebsites.net/Basket/CheckoutForm?handler=Complete";

    private DriverManager driverManager;
    private EShopHomePage eShopHomePage;
    private EShopLoginPage eShopLoginPage;
    private EShopBasketPage eShopBasketPage;
    private EShopCheckoutDetailsPage eShopCheckoutDetailsPage;



    @Given("^User opens the browser on EshopOnWeb Homepage$")
    public void user_opens_the_browser_on_EshopOnWeb_Homepage() {
        driverManager = DriverFactory.valueOf("CHROME").getDriverManager();
        eShopHomePage = new EShopHomePage(driverManager);
        eShopHomePage.goToHomePage();
    }

    @Given("^User clicks on login button$")
    public void user_clicks_on_login_button() {
        eShopHomePage.clickOnLoginButton();
        Assert.assertEquals(LOGIN_URL, driverManager.getDriver().getCurrentUrl());
    }

    @When("^User submits username and password$")
    public void user_submits_username_and_password() {
        eShopLoginPage = new EShopLoginPage(driverManager);
        eShopLoginPage.setUserName(USERNAME);
        eShopLoginPage.setPassword(PASSWORD);
        eShopLoginPage.clickOnLogin();
    }

    @Then("^User should be logged in$")
    public void user_should_be_logged_in() {
        eShopHomePage.verifyLoggedUser(USERNAME);
    }

    @Given("^User adds an item to the basket$")
    public void user_adds_an_item_to_the_basket() {
        eShopHomePage.clickOnAddToBasketByItemName(ITEM_TO_BUY);
        eShopBasketPage = new EShopBasketPage(driverManager);
        Assert.assertEquals(BASKET_URL, driverManager.getDriver().getCurrentUrl());
        eShopBasketPage.verifyItemList(ITEM_TO_BUY);
    }

    @When("^User clicks on checkout button$")
    public void user_clicks_on_checkout_button() {
        eShopBasketPage.clickOnCheckout();
        Assert.assertEquals(CHECKOUT_FORM_URL, driverManager.getDriver().getCurrentUrl());
    }

    @When("^User fills the checkout details page$")
    public void user_fills_the_checkout_details_page() {
        eShopCheckoutDetailsPage = new EShopCheckoutDetailsPage(driverManager);
        eShopCheckoutDetailsPage.fillCheckoutInfo();
        eShopCheckoutDetailsPage.clickOnCompletePurchase();
    }

    @Then("^User should finish the order$")
    public void user_should_finish_the_order() {
        Assert.assertEquals(CONFIRM_CHECKOUT_URL, driverManager.getDriver().getCurrentUrl());
    }

    @After
    public void shutDown() {
        driverManager.quitDriver();
    }
}