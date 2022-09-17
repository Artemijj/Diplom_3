import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.firefox.*;
import pageobject.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegistrationTest {
    String userName = "testqaname";
    String userEmail = "testqaemail@gmail.com";
    String userPassword = "testqapassword";
    String wrongPassword = "passw";
    String aToken;
    private WebDriver driver;

    @Before
    public void initialize() {
        ChromeOptions options = new ChromeOptions();
//        FirefoxOptions options = new FirefoxOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
//        driver = new FirefoxDriver(options);
        driver.get(new RegisterPage(driver).REGISTER_URL);
    }

    @Test
    @DisplayName("Success registration test")
    @Description("Успешная регистрация")
    public void successRegistrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registerPage.registrationFormFilling(userName, userEmail, userPassword);
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Войти']")));
        String expected = loginPage.LOGIN_URL;
        assertEquals(expected, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Wrong password registration test")
    @Description("Попытка регистрации с неверным паролем")
    public void wrongPasswordRegistrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        registerPage.registrationFormFilling(userName, userEmail, wrongPassword);
        String expected = "Некорректный пароль";
        assertEquals(expected, driver.findElement(By.xpath(".//div[@class='input__container']/p")).getText());
    }

    @After
    public void teardown() throws NullPointerException {
        driver.quit();
        new UserActivities().delete(userEmail, userPassword);
    }
}
