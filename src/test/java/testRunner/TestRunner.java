package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//					features= {".//Features/","@target/rerun.txt"},
					features= {".//Features/TS_007_End_to_End_test_based_on_the_requirement.feature","@target/rerun.txt"},
//					features= {".//Features/TS_005_Language_Level_Filters 1.feature"},
					//features= {".//Features/LoginDDTExcel.feature"},
//					features= {".//Features/Login.feature",".//Features/Registration.feature"},
//					features= {"@target/rerun.txt"},
					glue="stepDefinitions",
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true,   // to publish report in cucumber server
					//tags="@smoke"  // this will execute scenarios tagged with @sanity
					//tags="@regression"
					tags="@smoke and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@smoke and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@smoke or @regression" //Scenarios tagged with either @sanity or @regression
		)
public class TestRunner {

		}
