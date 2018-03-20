import cucumber.api.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * This class is responsible for reading each .feature file and execute its corresponding Steps file
 * 
 * @author Kleber Silva
 *
 */

@CucumberOptions (features = "src/test/resources/features", glue = {"steps"},
				  format = {
						     "pretty",
						     "html:target/cucumber-reports/testResult",
						     "json:target/cucumber-reports/testResult.json",
				 })

public class TestRunner extends AbstractTestNGCucumberTests {

	private TestNGCucumberRunner runner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		runner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Run each cucumber feature", dataProvider = "features")
	public void runFeature(CucumberFeatureWrapper cucumberFeature) {
		runner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return runner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		runner.finish();
	}
}
