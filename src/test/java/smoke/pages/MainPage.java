package smoke.pages;

import io.cucumber.java.bg.И;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smoke.core.BasePage;

public class MainPage extends BasePage {

    @FindBy(id = "navbarDropdown")
    public WebElement dropdownSandbox;

    @FindBy(xpath = "//a[@href='/food']")
    public WebElement pointFood;

    @FindBy(id = "reset")
    public WebElement buttonDeleteData;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String url = "http://localhost:8080/";

    @Дано("открыт стенд по адресу {string}")
    public void openStand(String str) {
        driver.get(url);
    }

    @Когда("Пользователь нажимает на выпадающий список 'Песочница'")
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
