package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String MAIN_URL = "https://stellarburgers.nomoreparties.site/";

    private By accountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By bunButton = By.xpath(".//span[text()='Булки']");
    private By sauceButton = By.xpath(".//span[text()='Соусы']");
    private By mainIngredientButton = By.xpath(".//span[text()='Начинки']");
    private By sauceIngredientButton = By.xpath(".//span[text()='Соусы']");
    private By bunIngredientButton = By.xpath(".//span[text()='Булки']");
    private By mainIngredientButtonClass = By.xpath(".//span[text()='Начинки']/parent::div");
    private By sauceIngredientButtonClass = By.xpath(".//span[text()='Соусы']/parent::div");
    private By bunIngredientButtonClass = By.xpath(".//span[text()='Булки']/parent::div");
    private By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");

    public void loginAccountButtonClick() {
        driver.findElement(loginAccountButton).click();
    }

    public void accountButtonClick() {
        driver.findElement(accountButton).click();
    }
     public void mainIngredientButtonClick() {
        driver.findElement(mainIngredientButton).click();
    }

    public void sauceIngredientButtonClick() {
        driver.findElement(sauceIngredientButton).click();
    }

    public void bunIngredientButtonClick() {
        driver.findElement(bunIngredientButton).click();
    }

    public WebElement mainIngredientButtonClassFind() {
        return driver.findElement(mainIngredientButtonClass);
    }

    public WebElement sauceIngredientButtonClassFind() {
        return driver.findElement(sauceIngredientButtonClass);
    }

    public WebElement bunIngredientButtonClassFind() {
        return driver.findElement(bunIngredientButtonClass);
    }
}
