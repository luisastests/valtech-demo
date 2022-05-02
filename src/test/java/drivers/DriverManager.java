package drivers;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {
    protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    protected abstract WebDriver createDriver();

    public void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().close();
            drivers.get().quit();
            drivers.remove();
        }
    }

    public WebDriver getDriver() {
        if (drivers.get() == null) {
            drivers.set(this.createDriver());
        }
        drivers.get().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
        return drivers.get();
    }
}