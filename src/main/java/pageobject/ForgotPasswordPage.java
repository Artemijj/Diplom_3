package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    private By enterButton = By.className("Auth_link__1fOlj");

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}

