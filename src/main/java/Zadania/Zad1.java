package Zadania;

import org.junit.Assert.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Zad1 {
    private WebDriver driver;

    @After
    public void end() {
        driver.quit();
    }

    @Given("^Open page \"([^\"]*)\"$")
    public void open_page(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
    }

    //będzie logować się na tego stworzonego użytkownika,
    @When("Sign in link clicked")
    public void signInClick() {
        WebElement signInClick = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signInClick.click();
    }

    @And("^Fill email form with \"([^\"]*)\"$")
    public void fill_email_form_with(String email) {
        WebElement fillMail = driver.findElement(By.className("form-control"));
        fillMail.clear();
        fillMail.sendKeys(email);
    }

    @And("^Fill password form with \"([^\"]*)\"$")
    public void fill_password_form_with(String password) {
        WebElement fillPass = driver.findElement(By.name("password"));
        fillPass.clear();
        fillPass.sendKeys(password);
    }

    @And("Click Sign in button")
    public void signIn2() {
        WebElement signInClick2 = driver.findElement(By.id("submit-login"));
        signInClick2.click();
    }

    @And("Click Add First Address button")
    public void clickAddresses() {
        WebElement clickAddressesLink = driver.findElement(By.xpath("//a[@href=\"https://prod-kurs.coderslab.pl/index.php?controller=address\"]"));
        clickAddressesLink.click();
    }

    @And("^Fill Address with \"([^\"]*)\"$")
    public void fill_Address_with(String adress) {
        WebElement input = driver.findElement(By.name("address1"));
        input.click();
        input.sendKeys(adress);
    }

    @And("^Fill Zip/Postal Code with \"([^\"]*)\"$")
    public void fill_Zip_Postal_Code_with(String zipcode) {
        WebElement postalCode = driver.findElement(By.name("postcode"));
        postalCode.click();
        postalCode.sendKeys(zipcode);
    }

    @And("^Fill City with \"([^\"]*)\"$")
    public void fill_City_with(String city) {
        WebElement newcity = driver.findElement(By.name("city"));
        newcity.sendKeys(city);
    }

    @And("^Fill Country with \"([^\"]*)\"$")
    public void fill_Country_with(String uk) {
        WebElement country = driver.findElement(By.name("id_country"));
        Select select = new Select(country);
        select.selectByVisibleText(uk);
    }

    @And("^Fill Phone with \"([^\"]*)\"$")
    public void fill_Phone_with(String newphone) {
        WebElement phone = driver.findElement(By.name("phone"));
        phone.click();
        phone.sendKeys(newphone);
    }

    @And("Click button Save")
    public void SaveOptions() {
        WebElement saveAddress = driver.findElement(By.cssSelector("footer > button"));
        saveAddress.click();
    }

    @Then("^Click Update on Address$")
    public void click_Update_on_Address() {
         try {
            Thread.sleep(10000);}
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        List<WebElement> addresscheck = driver.findElements(By.cssSelector("div.address-body > address"));
        WebElement element = addresscheck.get(addresscheck.size() - 1);
        System.out.println(element.getText());
        assertEquals("aaa aaa\n" +
                "Rzeczna\n" +
                "Katowice\n" +
                "20-200\n" +
                "United Kingdom\n" +
                "888888888",element.getText());
    }
}