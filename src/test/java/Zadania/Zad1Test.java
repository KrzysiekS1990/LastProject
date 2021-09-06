package Zadania;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Cucumber/Features",
        glue = {"Zadania"},
     // dryRun = true,
        plugin = {"pretty"})



public class Zad1Test {
}
