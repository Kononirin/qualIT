package smoke.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smoke.core.BasePage;
import smoke.core.BaseTest;

import java.util.List;

public class ListOfFoodPage extends BasePage {

    @FindBy(xpath = "//button[text()='Добавить']")
    private WebElement buttonAdd;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(id = "type")
    private WebElement dropdownType;

    @FindBy(xpath = "//option[@value='FRUIT']")
    private WebElement pointFruitType;

    @FindBy(id = "exotic")
    private WebElement checkBoxExotic;

    @FindBy(id = "save")
    private WebElement buttonSave;

    @FindBy(id = "save")
    private WebElement List;

    @FindBy(xpath = "//tr[5]/*")
    private List<WebElement> lastRowInTableFoods;

    public ListOfFoodPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ListOfFoodPage clickButtonAdd() {
        buttonAdd.click();
        return this;
    }

    public String receiveColorOfButtonAdd() {
        return buttonAdd.getCssValue("background-color");
    }

    public String receiveColorOfButtonSave() {
        return buttonSave.getCssValue("background-color");
    }

    String fruitName = "ЭкЗоТиЧеСкИй FrUiT";

    public ListOfFoodPage typeFruitName() {
        inputName.sendKeys(fruitName);
        return this;
    }

    String vegetableName = "`!@#$%^&*()_+?/~.♣☺♂{code};–<>";

    public ListOfFoodPage typeVegetableName() {
        inputName.sendKeys(vegetableName);
        return this;
    }

    public ListOfFoodPage clickDropdownTypeFruit() {
        dropdownType.click();
        pointFruitType.click();
        return this;
    }

    public ListOfFoodPage clickDropdownTypeVegetable() {
        dropdownType.click();
        return this;
    }

    public ListOfFoodPage clickCheckBoxExotic() {
        checkBoxExotic.click();
        return this;
    }

    public ListOfFoodPage clickButtonSave() {
        buttonSave.click();
        return this;
    }
}
