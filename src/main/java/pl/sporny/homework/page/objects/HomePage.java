package pl.sporny.homework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    @FindBy(css = "div.avatar-container.logged-avatar-placeholder")
    private WebElement userPage;

    @FindBy(css = "nav.wikia-menu-button.contribute")
    private WebElement contribute;

    @FindBy(css = "a[data-id='wikiavideoadd']")
    private WebElement addVideo;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (!"QM HomeWork Wikia".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the home page");
        }
    }

    public WebElement getUserPage() {
        return userPage;
    }

    public VideoAddPage addVideo() {
        contribute.click();
        addVideo.click();
        return new VideoAddPage(driver);
    }

}
