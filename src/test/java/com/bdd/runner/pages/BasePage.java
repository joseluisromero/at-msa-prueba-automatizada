package com.bdd.runner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;

    /**
     * bloque statico para  crear el driver una sola vez para todas  las instancia de las otras paginas
     */
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        //va ha esperar 10 segundo sino lanzara  un error si lo encuentra antes continuará
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void navigateTo(String url) {

        driver.get(url);
    }

    public WebElement findId(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    public WebElement findXpath(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElementXpath(String locator) {
        findXpath(locator).click();
    }
    public void clickElementById(String locator) {
        findId(locator).click();
    }

    public String getText(String locator) {
        return findXpath(locator).getText();
    }

}
