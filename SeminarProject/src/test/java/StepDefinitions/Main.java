package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeaturesTest/TestOHRM_EditProfile.feature", 
glue={"StepDefinitions"}, 
monochrome= true,
plugin = {"pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
)

public class Main {

}
