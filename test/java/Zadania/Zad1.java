package Zadania;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zad1 {
    private WebDriver driver;

    @Given ("Open page https://prod-kurs.coderslab.pl/")
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/");
    }
    //będzie logować się na tego stworzonego użytkownika,
    @When ("Sign in link clicked")
    public void signInClick() {
        WebElement signInClick = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signInClick.click();
    }

    @And ("Fill email form with drwkpoeygkqypbvmtf@bptfp.com")
    public void fillEmail(){
        WebElement fillMail = driver.findElement(By.className("form-control"));
        fillMail.clear();
    }

    @And ("Fill password form with 12345")
    public void fillPassword(){
        WebElement fillPass = driver.findElement(By.name("password"));
        fillPass.clear();
    }
    @And ("Click Sign in button")
    public  void signIn2(){
        WebElement signInClick2 = driver.findElement(By.id("submit-login"));
        signInClick2.click();
    }
    //wejdzie klikając w kafelek Addresses po zalogowaniu,
    @And ("Click Addresses button")
    public void Addresses() {
        WebElement clickAddressesButton = driver.findElement(By.id("address-link"));
        clickAddressesButton.click();
    }
    // kliknie w + Create new address,
    @And ("Click Add First Address button")
    public void clickAddresses() {
        WebElement clickAddressesLink = driver.findElement(By.xpath("//a[@href=\"https://prod-kurs.coderslab.pl/index.php?controller=address\"]"));
        clickAddressesLink.click();
    }
    //wypełni formularz New address - dane powinny być pobierane z tabeli Examples w Gherkinie
    @And ("Fill Address with Rzeczna")
    public void FillAddress(){
        WebElement Address = driver.findElement(By.className("address1"));
        Address.click();
        Address.sendKeys();
    }
    @And ("Fill Zip/Postal Code with 20-200")
    public void FillZip(){
        WebElement postalCode = driver.findElement(By.className("postcode"));
        postalCode.click();
        postalCode.sendKeys();
    }
    @And ("Fill City with Katowice")
    public void FillCity(){
        WebElement city = driver.findElement(By.className("city"));
        city.click();
        city.sendKeys();
    }
    @And ("And Fill Country with United Kingdom")
    public void FillCountry(){
        WebElement country = driver.findElement(By.id("id_country"));
        country.click();
    }
    @Then ("Click button Save")
    public void SaveOptions(){
        WebElement saveAddress = driver.findElement(By.className("btn btn-primary float-xs-right"));
        saveAddress.click();
    }
}