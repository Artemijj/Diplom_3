package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";

    private By nameField = By.xpath(".//form/fieldset[1]/div/div/input");
    private By emailField = By.xpath(".//form/fieldset[2]/div/div/input");
    private By passwordField = By.xpath(".//form/fieldset[3]/div/div/input");
    private By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By enterButton = By.className("Auth_link__1fOlj");

    public void setNameField(String userName) {
        driver.findElement(nameField).sendKeys(userName);
    }

    public void setEmailField(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
    }

    public void setPasswordField(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    public void registrationFormFilling(String userName, String userEmail, String userPassword) {
        setNameField(userName);
        setEmailField(userEmail);
        setPasswordField(userPassword);
        clickRegistrationButton();
    }
}
