package smoke.pages;

import io.cucumber.java.bg.И;
import io.qameta.allure.Step;
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



    @И("Пользователь нажимает на выпадающий список 'Песочница'")
    public MainPage clickDropdownSandbox() {
        dropdownSandbox.click();
        return this;
    }

    @И("Пользователь выбирает в выпадающем списке пункт 'Товары'")
    public ListOfFoodPage clickPointFood() {
        pointFood.click();
        return new ListOfFoodPage(driver);
    }

    @И("Пользователь выбирает в выпадающем списке пункт 'Сброс данных'")
    public MainPage clickPointDeleteData() {
        buttonDeleteData.click();
        return this;
    }

}
