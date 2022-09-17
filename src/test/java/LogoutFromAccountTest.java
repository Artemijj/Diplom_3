import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.LoginPage;
import pageobject.*;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LogoutFromAccountTest {
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
//        Этот код необходим для выполнения теста в Firefox
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        loginPage.enterFormFilling(userEmail, userPassword);
        MainPage mainPage = new MainPage(driver);
//        Этот код необходим для выполнения теста в Firefox
//        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        mainPage.accountButtonClick();
    }

    @Test
    @DisplayName("Logout test")
    @Description("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void logoutTest() {
        AccountPage accountPage = new AccountPage(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Выход']")));
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        accountPage.exitButtonClick();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.className("Auth_login__3hAey")));
        LoginPage loginPage = new LoginPage(driver);
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        String expected = loginPage.LOGIN_URL;
        assertEquals(expected, driver.getCurrentUrl());
    }
    @After
    public void teardown() {
        driver.quit();
        new UserActivities().delete(userEmail,userPassword);
    }


}
