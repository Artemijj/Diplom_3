package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    private By emailField = By.xpath(".//form/fieldset[1]/div/div/input");
    private By passwordField = By.xpath(".//form/fieldset[2]/div/div/input");
    private By enterButton = By.xpath(".//button[text()='Войти']");

    public void setEmailField(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
    }

    public void setPasswordField(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void enterFormFilling(String userEmail, String userPassword) {
        setEmailField(userEmail);
        setPasswordField(userPassword);
        clickEnterButton();
    }
}
