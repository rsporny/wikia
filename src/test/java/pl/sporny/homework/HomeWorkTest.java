package pl.sporny.homework;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pl.sporny.homework.driver.Driver;
import pl.sporny.homework.page.objects.FilePage;
import pl.sporny.homework.page.objects.HomePage;
import pl.sporny.homework.page.objects.LoginPage;
import pl.sporny.homework.page.objects.VideoAddPage;
import pl.sporny.homework.page.objects.VideoListPage;

public class HomeWorkTest {

    private Driver driver;
    private Configuration conf;

    @BeforeClass
    public void setUpBeforeClass() throws IOException {
        conf = Configuration.getInstance();
    }

    @BeforeMethod
    public void setUp() {
        driver = new Driver(System.getProperty("browser"));
    }

    @AfterMethod
    public void clear() {
        driver.quit();
        driver = null;
    }

    @Test
    public void testLogin() {
        driver.get("http://qm-homework.wikia.com");
        LoginPage loginPage = new LoginPage(driver.getDriver());
        HomePage homePage = loginPage.loginAs(conf.get("username"), conf.get("password"));
        assertThat(homePage.getUserPage().isDisplayed()).isTrue();
    }

    @Test
    public void testVideoAdd() {
        driver.get("http://qm-homework.wikia.com");
        LoginPage loginPage = new LoginPage(driver.getDriver());
        HomePage homePage = loginPage.loginAs(conf.get("username"), conf.get("password"));
        VideoAddPage videoAddPage = homePage.addVideo();
        videoAddPage.typeVideoUrl("http://www.youtube.com/watch?v=h9tRIZyTXTI");
        VideoListPage videoListPage = videoAddPage.submitVideo();
        String videoTitle = videoListPage.getJustAddedVideo().getText().replace("File:", "");
        assertThat(videoListPage.getMessageBox().getText()).contains("Video page").contains("was successfully added");
        FilePage filePage = videoListPage.clickJustAddedVideo();
        assertThat(filePage.getFileTitle().getText()).isEqualTo(videoTitle);
    }
}
