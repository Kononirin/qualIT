package smoke.tests;


import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import smoke.core.BaseTest;
import smoke.pages.ListOfFoodPage;
import smoke.pages.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestsPositive extends BaseTest {

    MainPage mainPage;
    ListOfFoodPage listOfFoodPage;

    List<String> listWithFruitCyrillicAndLatinSymbols = Arrays.asList(
            "5", "ЭкЗоТиЧеСкИй FrUiT!", "Фрукт", "true");

    @Owner("Irina Shlyapina")
    @DisplayName("Проверка добавления экзотического фрукта")
    @Test
    public void testAddingExoticFruit() {
        mainPage = new MainPage(driver);
        listOfFoodPage = new ListOfFoodPage(driver);

        new MainPage(driver)
            .clickDropdownSandbox()
            .clickPointFood()
            .clickButtonAdd()
            .typeName(listWithFruitCyrillicAndLatinSymbols.get(1))
            .clickDropdownTypeFruit()
            .clickCheckBoxExotic()
            .clickButtonSave();

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

        new MainPage(driver)
                .clickDropdownSandbox()
                .clickPointDeleteData();
    }

    List<String> listWithVegetableSpecialCharacters = Arrays.asList(
            "5", "`!@#$%^&*()_+?/~.♣☺♂{code};–<>", "Овощ", "false");

    @DisplayName("Проверка добавления овоща")
    @Test
    public void testAddingVegetable() {
        mainPage = new MainPage(driver);
        listOfFoodPage = new ListOfFoodPage(driver);

        new MainPage(driver)
                .clickDropdownSandbox()
                .clickPointFood()
                .clickButtonAdd()
                .typeName(listWithVegetableSpecialCharacters.get(1))
                .clickDropdownTypeVegetable()
                .clickButtonSave();

        List<WebElement> lastRowInTableOfFoods = driver.findElements(By.xpath(
                "//tr[5]/*"));

        List<String> lastRowInTableOfFoodsStr = new ArrayList<>();

        for (WebElement element : lastRowInTableOfFoods) {
            lastRowInTableOfFoodsStr.add(element.getText());
        }

        Assertions.assertEquals(
                listWithVegetableSpecialCharacters,
                lastRowInTableOfFoodsStr,
                "Не совпадают элементы в таблице товаров");

        new MainPage(driver)
                .clickDropdownSandbox()
                .clickPointDeleteData();
    }

    @Test
    public void testColorOfButtonAdd() {
        mainPage = new MainPage(driver);
        listOfFoodPage = new ListOfFoodPage(driver);

        String colorOfButtonAdd = new MainPage(driver)
                .clickDropdownSandbox()
                .clickPointFood()
                .receiveColorOfButtonAdd();

        Assertions.assertEquals(colorOfButtonAdd, "rgba(0, 123, 255, 1)",
                "Отличается цвет кнопки");
    }

    @Test
    public void testColorOfButtonSave() {
        mainPage = new MainPage(driver);
        listOfFoodPage = new ListOfFoodPage(driver);

        String colorOfButtonSave = new MainPage(driver)
                .clickDropdownSandbox()
                .clickPointFood()
                .clickButtonAdd()
                .receiveColorOfButtonSave();

        Assertions.assertEquals(colorOfButtonSave, "rgba(0, 123, 255, 1)",
                "Отличается цвет кнопки");
    }
}
