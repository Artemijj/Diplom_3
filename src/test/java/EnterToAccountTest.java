import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.*;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class EnterToAccountTest {
    String userName = "testqaname";
    String userEmail = "testqaemail@gmail.com";
    String userPassword = "testqapassword";
    private WebDriver driver;

    @Before
    public void initialize() {
        new UserActivities().create(userEmail, userPassword, userName);
        ChromeOptions options = new ChromeOptions();
//        FirefoxOptions options = new FirefoxOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
//        driver = new FirefoxDriver(options);
    }

    @Test
    @DisplayName("Enter from login account on main page test")
    @Description("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void enterFromLoginAccountOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        driver.get(mainPage.MAIN_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        mainPage.loginAccountButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Войти']")));
        LoginPage loginPage = new LoginPage(driver);
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        loginPage.enterFormFilling(userEmail, userPassword);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Соберите бургер']")));
        String expected = mainPage.MAIN_URL;
        assertEquals(expected, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Enter from account button on main page test")
    @Description("Проверка входа через кнопку «Личный кабинет»")
    public void enterFromAccountButtonOnMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        driver.get(mainPage.MAIN_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        mainPage.accountButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Войти']")));
        LoginPage loginPage = new LoginPage(driver);
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        loginPage.enterFormFilling(userEmail, userPassword);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Соберите бургер']")));
        String expected = mainPage.MAIN_URL;
        assertEquals(expected, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Enter from enter button on register page test")
    @Description("Проверка входа через кнопку в форме регистрации")
    public void enterFromEnterButtonOnRegisterPageTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        driver.get(registerPage.REGISTER_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        registerPage.clickEnterButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Войти']")));
        LoginPage loginPage = new LoginPage(driver);
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        loginPage.enterFormFilling(userEmail, userPassword);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Соберите бургер']")));
        MainPage mainPage = new MainPage(driver);
        String expected = mainPage.MAIN_URL;
        assertEquals(expected, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Enter from enter button on forgot-password page test")
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    public void enterFromEnterButtonOnForgotPasswordPageTest() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(forgotPasswordPage.FORGOT_PASSWORD_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        forgotPasswordPage.clickEnterButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Войти']")));
        LoginPage loginPage = new LoginPage(driver);
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        loginPage.enterFormFilling(userEmail, userPassword);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Соберите бургер']")));
        MainPage mainPage = new MainPage(driver);
        String expected = mainPage.MAIN_URL;
        assertEquals(expected, driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        driver.quit();
        new UserActivities().delete(userEmail, userPassword);
    }
}
