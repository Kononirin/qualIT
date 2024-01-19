package smoke.core;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        BasePage.setDriver(driver);
    }



    @After
    public void afterMethod() {
        driver.quit();
    }
}
