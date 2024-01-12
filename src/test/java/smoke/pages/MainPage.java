package smoke.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smoke.core.BasePage;

public class MainPage extends BasePage {

    @FindBy(id = "navbarDropdown")
    private WebElement dropdownSandbox;

    @FindBy(xpath = "//a[@href='/food']")
    private WebElement pointFood;

    @FindBy(id = "reset")
    private WebElement buttonDeleteData;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public MainPage clickDropdownSandbox() {
        dropdownSandbox.click();
        return this;
    }

    public ListOfFoodPage clickPointFood() {
        pointFood.click();
        return new ListOfFoodPage(driver);
    }

    public MainPage clickButtonDeleteData() {
        buttonDeleteData.click();
        return this;
    }

}
