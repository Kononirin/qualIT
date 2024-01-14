package smoke.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smoke.core.BasePage;

public class ListOfFoodPage extends BasePage {

    @FindBy(xpath = "//button[text()='Добавить']")
    private WebElement buttonAdd;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "type")
    private WebElement dropdownType;

    @FindBy(xpath = "//option[@value='FRUIT']")
    private WebElement dropdownPointFruitType;

    @FindBy(xpath = "//option[@value='VEGETABLE']")
    private WebElement dropdownPointVegetableType;

    @FindBy(id = "exotic")
    private WebElement checkBoxExotic;

    @FindBy(id = "save")
    private WebElement buttonSave;

    public ListOfFoodPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step ("Пользователь нажимает на кнопку 'Добавить'")
    public ListOfFoodPage clickButtonAdd() {
        buttonAdd.click();
        return this;
    }

    @Step("Получаем цвет кнопки 'Добавить'")
    public String receiveColorOfButtonAdd() {
        return buttonAdd.getCssValue("background-color");
    }

    @Step("Получаем цвет кнопки 'Сохранить'")
    public String receiveColorOfButtonSave() {
        return buttonSave.getCssValue("background-color");
    }

    @Step("Пользователь вводит наименование")
    public ListOfFoodPage typeName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    @Step("Пользователь выбирает в выпадающем списке тип 'Фрукт'")
    public ListOfFoodPage clickDropdownTypeFruit() {
        dropdownType.click();
        dropdownPointFruitType.click();
        return this;
    }

    @Step("Пользователь выбирает в выпадающем списке тип 'Овощ'")
    public ListOfFoodPage clickDropdownTypeVegetable() {
        dropdownType.click();
        dropdownPointVegetableType.click();
        return this;
    }

    @Step("Пользователь выбирает чек-бокс 'Экзотический'")
    public ListOfFoodPage clickCheckBoxExotic() {
        checkBoxExotic.click();
        return this;
    }

    @Step("Пользователь нажимает кнопку 'Сохранить'")
    public MainPage clickButtonSave() {
        buttonSave.click();
        return new MainPage(driver);
    }
}
