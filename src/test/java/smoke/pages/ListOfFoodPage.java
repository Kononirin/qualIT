package smoke.pages;

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

    public ListOfFoodPage typeName(String name) {
        inputName.sendKeys(name);
        return this;
    }

    public ListOfFoodPage clickDropdownTypeFruit() {
        dropdownType.click();
        dropdownPointFruitType.click();
        return this;
    }

    public ListOfFoodPage clickDropdownTypeVegetable() {
        dropdownType.click();
        dropdownPointVegetableType.click();
        return this;
    }

    public ListOfFoodPage clickCheckBoxExotic() {
        checkBoxExotic.click();
        return this;
    }

    public MainPage clickButtonSave() {
        buttonSave.click();
        return new MainPage(driver);
    }
}
