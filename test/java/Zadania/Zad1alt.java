package Zadania;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Zad1alt {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://prod-kurs.coderslab.pl/index.php ");
    }

    @After
    public void afterEach() {
        //        driver.quit();
    }

    @Test
    public void signInAndOrder() {
        //będzie logować się na tego stworzonego użytkownika,
        WebElement signIn = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signIn.click();
        WebElement signIn2 = driver.findElement(By.className("form-control"));
        signIn2.sendKeys("drwkpoeygkqypbvmtf@bptfp.com");
        WebElement signIn3 = driver.findElement(By.name("password"));
        signIn3.sendKeys("12345");
        WebElement signIn4 = driver.findElement(By.id("submit-login"));
        signIn4.click();
        try {
            Thread.sleep(2000);}
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //wejdzie klikając w kafelek Addresses po zalogowaniu
        WebElement clickAddressesLink = driver.findElement(By.xpath("//a[@id='addresses-link']"));
        clickAddressesLink.click();
        //kliknie w + Create new address,
        WebElement clickAddressesLink2 = driver.findElement(By.xpath("//a[@href=\"https://prod-kurs.coderslab.pl/index.php?controller=address\"]"));
        clickAddressesLink2.click();
        //wypełni formularz New address
        WebElement Address = driver.findElement(By.xpath("//input[@name='address1']"));
        Address.sendKeys("Rzeczna");
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("Katowice");
        WebElement postalCode = driver.findElement(By.xpath("//input[@name='postcode']"));
        postalCode.sendKeys("20-200");
        WebElement country = driver.findElement(By.xpath("//select[@name='id_country']"));
        country.click();
        WebElement saveAddress = driver.findElement(By.xpath("//button[@class='btn btn-primary float-xs-right']"));
        saveAddress.click();
    }
}