package tmsandbox;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources", glue = { "tmsandbox" }, tags = {
		"@categories" }, plugin = { "json:target/cucumber-report-composite.json", "pretty", "html:target/cucumber/",
				"rerun:target/rerun.txt" })
public class Runner {

}
