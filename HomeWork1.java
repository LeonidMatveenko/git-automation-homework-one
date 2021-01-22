// I can win
// При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
//
//Открыть https://pastebin.com или аналогичный сервис в любом браузере
//Создать New Paste со следующими деталями:
//* Код: "Hello from WebDriver"
//
//* Paste Expiration: "10 Minutes"
//
//* Paste Name / Title: "helloweb"
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork1 {


    private WebDriver driver;

    @BeforeMethod(alwaysRun = true) //preconditions
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public void NewPaste() throws InterruptedException {
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.id("postform-text")));
        WebElement searchField = driver.findElement(By.id("postform-text"));
        searchField.sendKeys("Hello from WebDriver");



        WebElement dropdown = driver.findElement(By.id("select2-postform-expiration-container")); //нашли дроп даун
        dropdown.click();

        List<WebElement> dropDownValues = driver.findElement(By.id("select2-postform-expiration-results")) // добавляем все результаты дроп даун в лист
                .findElements(By.tagName("li")); // по тегу
        dropDownValues.get(2).click();

        WebElement searchSecondField = driver.findElement(By.id("postform-name"));
        searchSecondField.sendKeys("helloweb");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button"));
        searchBtn.get(0).click();

    }

    @AfterMethod//postconditions
    public void browserCloseDown() {
        driver.quit();
        driver = null;
    }

}

