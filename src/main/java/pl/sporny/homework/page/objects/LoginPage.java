package pl.sporny.homework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(css = "a[data-id='login']")
    private WebElement signIn;

    @FindBy(id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(css = "div.input-group.login-button > input")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (!"QM HomeWork Wikia".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the file page");
        }
    }

    public HomePage loginAs(String username, String password) {
        signIn.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new HomePage(driver);
    }
}
