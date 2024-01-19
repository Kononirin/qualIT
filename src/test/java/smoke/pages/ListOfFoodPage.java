package smoke.pages;

import io.cucumber.java.After;
import io.cucumber.java.bg.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smoke.core.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfFoodPage extends BasePage {

    protected WebDriver driver;

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

//    String url = "http://localhost:8080/";
//
//    @Дано("открыт стенд по адресу {string}")
//    public void openStand(String str) {
//        driver.get(url);
//    }

    @И("Пользователь нажимает на кнопку 'Добавить'")
    public ListOfFoodPage clickButtonAdd() {
        buttonAdd.click();
        return this;
    }

    @И("Получаем цвет кнопки 'Добавить'")
    public String receiveColorOfButtonAdd() {
        return buttonAdd.getCssValue("background-color");
    }

    @И("Получаем цвет кнопки 'Сохранить'")
    public String receiveColorOfButtonSave() {
        return buttonSave.getCssValue("background-color");
    }

    @И("Пользователь вводит наименование {string}")
    public ListOfFoodPage typeName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    @И("Пользователь выбирает в выпадающем списке тип 'Фрукт'")
    public ListOfFoodPage clickDropdownTypeFruit() {
        dropdownType.click();
        dropdownPointFruitType.click();
        return this;
    }

    @И("Пользователь выбирает в выпадающем списке тип 'Овощ'")
    public ListOfFoodPage clickDropdownTypeVegetable() {
        dropdownType.click();
        dropdownPointVegetableType.click();
        return this;
    }

    @И("Пользователь выбирает чек-бокс 'Экзотический'")
    public ListOfFoodPage clickCheckBoxExotic() {
        checkBoxExotic.click();
        return this;
    }

    @И("Пользователь нажимает кнопку 'Сохранить'")
    public MainPage clickButtonSave() {
        buttonSave.click();
        return new MainPage(driver);
    }

    @Тогда("Проверяем, что в последней строке таблицы Товары отображаются введенные данные")
    public void assertResult() {
        List<String> listWithFruitCyrillicAndLatinSymbols = Arrays.asList(
                "5", "ЭкЗоТиЧеСкИй FrUiT!", "Фрукт", "true");

        List<WebElement> lastRowInTableOfFoods = driver.findElements(By.xpath(
                "//tr[5]/*"));

        List<String> lastRowInTableOfFoodsStr = new ArrayList<>();

        for (WebElement element : lastRowInTableOfFoods) {
            lastRowInTableOfFoodsStr.add(element.getText());
        }

        Assertions.assertEquals(
                listWithFruitCyrillicAndLatinSymbols,
                lastRowInTableOfFoodsStr,
                "Не совпадают элементы в таблице товаров");
    }

    @After
    public void tearDown() {

        driver.quit();
    }

}
