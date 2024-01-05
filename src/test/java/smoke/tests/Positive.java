package smoke.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import smoke.core.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

public class Positive extends BaseTest {

    private static final By dropdownSandbox = By.id("navbarDropdown");
    private static final By pointFood = By.xpath("//a[@href='/food']");
    private static final By buttonAdd = By.xpath("//button[text()='Добавить']");
    private static final By inputName = By.id("name");
    private static final By dropdownType = By.id("type");
    private static final By pointFruitType = By.xpath("//option[@value='FRUIT']");
    private static final By checkBoxExotic = By.id("exotic");
    private static final By buttonSave = By.id("save");

    @Test
    public void testAddingExoticFruit() {

        String expectButtonColor = "rgba(0, 123, 255, 1)";
        List<String> expectedElementsStr = Arrays.asList("5", "ЭкЗоТиЧеСкИй FrUiT", "Фрукт", "true");

        driver.findElement(dropdownSandbox).click();
        driver.findElement(pointFood).click();
        String buttonAddColor = driver.findElement(buttonAdd).getCssValue("background-color");
        assertThat(buttonAddColor,equalToIgnoringCase(expectButtonColor));
        driver.findElement(buttonAdd).click();
        driver.findElement(inputName).sendKeys("ЭкЗоТиЧеСкИй FrUiT");
        driver.findElement(dropdownType).click();
        driver.findElement(pointFruitType).click();
        driver.findElement(checkBoxExotic).click();
        String buttonSaveColor = driver.findElement(buttonAdd).getCssValue("background-color");
        assertThat(buttonSaveColor,equalToIgnoringCase(expectButtonColor));
        driver.findElement(buttonSave).click();

        List<WebElement> actualElements = driver.findElements(By.xpath("//tr[5]/*"));

        List<String> actualElementsStr = new ArrayList<>();

        actualElements.forEach(element -> actualElementsStr.add(element.getText()));

        Assertions.assertEquals(expectedElementsStr, actualElementsStr,
                "Не совпадают элементы в таблице товаров");

    }
}
