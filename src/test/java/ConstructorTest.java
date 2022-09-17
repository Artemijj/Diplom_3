import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.firefox.*;
import pageobject.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    private WebDriver driver;

    @Before
    public void initialize() {
        ChromeOptions options = new ChromeOptions();
//        FirefoxOptions options = new FirefoxOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
//        driver = new FirefoxDriver(options);
        driver.get(new MainPage(driver).MAIN_URL);
    }

    @Test
    @DisplayName("Main ingredient test")
    @Description("Проверка, что работает переход к разделу «Начинки»")
    public void mainIngredientTest() {
        MainPage mainPage = new MainPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        mainPage.mainIngredientButtonClick();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String actual = mainPage.mainIngredientButtonClassFind().getAttribute("class");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Sauce ingredient test")
    @Description("Проверка, что работает переход к разделу «Соусы»")
    public void sauceIngredientTest() {
        MainPage mainPage = new MainPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        mainPage.sauceIngredientButtonClick();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String actual = mainPage.sauceIngredientButtonClassFind().getAttribute("class");
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Bun ingredient test")
    @Description("Проверка, что работает переход к разделу «Булки»")
    public void bunIngredientTest() {
        MainPage mainPage = new MainPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("y = document.getElementsByClassName('Modal_modal_overlay__x2ZCr');aNode = y[0];aNode.style.display = 'none';aNode = y[1];aNode.style.display = 'none';");
        mainPage.sauceIngredientButtonClick();
        mainPage.bunIngredientButtonClick();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String actual = mainPage.bunIngredientButtonClassFind().getAttribute("class");
        assertEquals(expected, actual);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
