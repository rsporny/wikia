package pl.sporny.homework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoListPage {

    private final WebDriver driver;

    @FindBy(css = "div.msg")
    private WebElement messageBox;

    @FindBy(css = "div.msg > a")
    private WebElement justAddedVideo;

    public VideoListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (driver.getCurrentUrl() == null || !driver.getCurrentUrl().contains("Special:Videos")) {
            throw new IllegalStateException("This is not the video list page");
        }
    }

    public WebElement getMessageBox() {
        return messageBox;
    }

    public WebElement getJustAddedVideo() {
        return justAddedVideo;
    }

    public FilePage clickJustAddedVideo() {
        justAddedVideo.click();
        return new FilePage(driver);
    }

}
