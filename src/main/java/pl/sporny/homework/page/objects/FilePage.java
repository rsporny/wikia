package pl.sporny.homework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilePage {

    @FindBy(css = "header#WikiaPageHeader h1")
    private WebElement fileTitle;

    public FilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        if (driver.getCurrentUrl() == null || !driver.getCurrentUrl().contains("File:")) {
            throw new IllegalStateException("This is not the file page");
        }
    }

    public WebElement getFileTitle() {
        return fileTitle;
    }

}
