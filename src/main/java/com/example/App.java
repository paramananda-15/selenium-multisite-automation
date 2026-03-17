package com.example;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WindowType;

import java.time.Duration;

public class App {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ---------------- TAB 1 ----------------
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println("SauceDemo login success");
        Thread.sleep(3000);

        // ---------------- TAB 2 ----------------
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        System.out.println("Practice Test login success");
        Thread.sleep(3000);

        // ---------------- TAB 3 ----------------
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://automationexercise.com/");

        Thread.sleep(3000);

        // close popup if present
        try {
            driver.findElement(By.xpath("//svg")).click();
            System.out.println("Ad popup closed");
        } catch (Exception e) {
            System.out.println("No popup ad");
        }

        WebElement product =
                driver.findElement(By.cssSelector("a[data-product-id='1']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", product);

        Thread.sleep(1000);

        product.click();

        System.out.println("Product added to cart");
        Thread.sleep(4000);

        driver.quit();
    }
}
