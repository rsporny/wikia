package pl.sporny.homework.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pl.sporny.homework.Configuration;

public class Driver {

    private final WebDriver driver;
    private final Configuration conf = Configuration.getInstance();

    public Driver(String browser) {
        driver = getBrowser(browser);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(conf.get("timeout.pageload")), TimeUnit.SECONDS);
    }

    private WebDriver getBrowser(String browser) {
        switch (browser) {
        case "firefox":
            return new FirefoxDriver();
        case "chrome":
            return new ChromeDriver();
        default:
            return new FirefoxDriver();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void get(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

}
