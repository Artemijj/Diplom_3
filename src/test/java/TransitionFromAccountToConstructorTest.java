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

public class TransitionFromAccountToConstructorTest {
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
        LoginPage loginPage = new LoginPage(driver);
        driver.get(loginPage.LOGIN_URL);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        loginPage.enterFormFilling(userEmail, userPassword);
        MainPage mainPage = new MainPage(driver);
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        mainPage.accountButtonClick();
    }

    @Test
    @DisplayName("Transition by constructor button test")
    @Description("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void transitionByConstructorButtonTest() {
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        accountPage.constructorButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Соберите бургер']")));
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        String expected = mainPage.MAIN_URL;
        assertEquals(expected, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Transition by stellar burger logo test")
    @Description("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void transitionByStellarBurgerLogoTest() {
        MainPage mainPage = new MainPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        accountPage.stellarBurgerLogoClick();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Соберите бургер']")));
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        String expected = mainPage.MAIN_URL;
        assertEquals(expected, driver.getCurrentUrl());
    }

    @After
    public void teardown() {
        driver.quit();
        new UserActivities().delete(userEmail, userPassword);
    }
}
