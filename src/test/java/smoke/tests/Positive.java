package smoke.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import smoke.core.BaseTest;
import smoke.pages.ListOfFoodPage;
import smoke.pages.MainPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Positive extends BaseTest {

    MainPage mainPage;
    ListOfFoodPage listOfFoodPage;

    @Test
    public void testAddingExoticFruit() {
        mainPage = new MainPage(driver);
        listOfFoodPage = new ListOfFoodPage(driver);

        List<String> expectedElementsStr = Arrays.asList(
                "5", "ЭкЗоТиЧеСкИй FrUiT", "Фрукт", "true");

        new MainPage(driver)
            .clickDropdownSandbox()
            .clickPointFood()
            .clickButtonAdd()
            .typeFruitName()
            .clickDropdownTypeFruit()
            .clickCheckBoxExotic()
            .clickButtonSave();

        List<WebElement> actualElements = driver.findElements(By.xpath(
                "//tr[5]/*"));

        List<String> actualElementsStr = new ArrayList<>();

        for (WebElement element : actualElements) {
            actualElementsStr.add(element.getText());
        }

        Assertions.assertEquals(expectedElementsStr, actualElementsStr,
                "Не совпадают элементы в таблице товаров");
    }

    @Test
    public void testAddingVegetable() {
        mainPage = new MainPage(driver);
        listOfFoodPage = new ListOfFoodPage(driver);

        List<String> expectedElementsStr = Arrays.asList(
                "5", "`!@#$%^&*()_+?/~.♣☺♂{code};–<>", "Овощ", "false");

        new MainPage(driver)
                .clickDropdownSandbox()
                .clickPointFood()
                .clickButtonAdd()
                .typeVegetableName()
                .clickDropdownTypeVegetable()
                .clickButtonSave();

        List<WebElement> actualElements = driver.findElements(By.xpath(
                "//tr[5]/*"));

        List<String> actualElementsStr = new ArrayList<>();

        for (WebElement element : actualElements) {
            actualElementsStr.add(element.getText());
        }

        Assertions.assertEquals(expectedElementsStr, actualElementsStr,
                "Не совпадают элементы в таблице товаров");
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
