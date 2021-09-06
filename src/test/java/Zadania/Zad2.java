package Zadania;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Zad2 {
    private WebDriver driver;

    @Before
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://prod-kurs.coderslab.pl/index.php ");
    }

    @After
    public void afterEach() throws IOException {
       //zrobi screenshot z potwierdzeniem zamówienia i kwotą.
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(scrFile, new File("C:\\screenshots\\screenshot.png"));
        //        driver.quit();
    }

    @Test
    public void signInAndOrder()  {
        //zaloguje się na tego samego użytkownika z zadania 1
        WebElement signIn = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
        signIn.click();
        WebElement signIn2 = driver.findElement(By.className("form-control"));
        signIn2.sendKeys("drwkpoeygkqypbvmtf@bptfp.com");
        WebElement signIn3 = driver.findElement(By.name("password"));
        signIn3.sendKeys("12345");
        WebElement signIn4 = driver.findElement(By.id("submit-login"));
        signIn4.click();
        //wybierze do zakupu Hummingbird Printed Sweater
        WebElement search1 = driver.findElement(By.xpath("//input[@class='ui-autocomplete-input']"));
        search1.sendKeys("Hummingbird Printed Sweater");
        WebElement search2 = driver.findElement(By.xpath("//i[@class='material-icons search']"));
        search2.click();
        WebElement chooseProduct = driver.findElement(By.xpath("//article[@data-id-product='2']"));
        chooseProduct.click();
        //wybierze rozmiar M
        WebElement chooseSize = driver.findElement(By.xpath("//option[@title='M']"));
        chooseSize.click();
        try {
            Thread.sleep(3000);}
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //wybierze 5 sztuk według parametru podanego w teście
        WebElement chooseQuantity = driver.findElement(By.id("quantity_wanted"));
        chooseQuantity.clear();
        chooseQuantity.sendKeys("5");
        //dodaj produkt do koszyka,
        WebElement addToCart = driver.findElement(By.xpath("//button[@data-button-action='add-to-cart']"));
        addToCart.click();
        //przejdzie do opcji - checkout,
        try {
            Thread.sleep(8000);}
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        new WebDriverWait(driver, 60, 1000).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-primary']")));
        WebElement checkOutOption = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        checkOutOption.click();
        try {
            Thread.sleep(8000);}
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        WebElement checkOutOption2 = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        checkOutOption2.click();
        //potwierdzi address
        WebElement confirmAddress = driver.findElement(By.xpath("//button[@name='confirm-addresses']"));
        confirmAddress.click();
        //wybierze metodę odbioru
        WebElement confirmDelivery = driver.findElement(By.name("confirmDeliveryOption"));
        confirmDelivery.click();
        //wybierze opcję płatności
        WebElement paymentOption = driver.findElement(By.id("payment-option-1"));
        paymentOption.click();
        //kliknie na "order with an obligation to pay"
        WebElement obligation = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        obligation.click();
        WebElement obligation2 = driver.findElement(By.id("payment-confirmation"));
        obligation2.click();
    }
}
