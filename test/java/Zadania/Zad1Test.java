package Zadania;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/LastProject/src/Cucumber/Features",
        plugin = {"pretty","html:out"})


public class Zad1Test {
}
