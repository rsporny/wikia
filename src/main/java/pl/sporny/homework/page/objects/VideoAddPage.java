package pl.sporny.homework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoAddPage {

    private final WebDriver driver;

    @FindBy(id = "wpWikiaVideoAddUrl")
    private WebElement videoAddInput;

    @FindBy(css = "div.submits > input")
    private WebElement submit;

    public VideoAddPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (driver.getCurrentUrl() == null || !driver.getCurrentUrl().contains("Special:WikiaVideoAdd")) {
            throw new IllegalStateException("This is not the video add page");
        }
    }

    public VideoAddPage typeVideoUrl(String videoUrl) {
        videoAddInput.sendKeys(videoUrl);
        return this;
    }

    public VideoListPage submitVideo() {
        submit.click();
        return new VideoListPage(driver);

    }

}
