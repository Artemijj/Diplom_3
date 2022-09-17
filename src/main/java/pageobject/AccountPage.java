package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String ACCOUNT_PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By stellarBurgerLogo = By.className("AppHeader_header__logo__2D0X2");
    private By exitButton = By.xpath(".//html/body/div/div/main/div/nav/ul/li/button[text()='Выход']");

    public void constructorButtonClick() {
        driver.findElement(constructorButton).click();
    }

    public void stellarBurgerLogoClick() {
        driver.findElement(stellarBurgerLogo).click();
    }

    public void exitButtonClick() {
        driver.findElement(exitButton).click();
    }
}
