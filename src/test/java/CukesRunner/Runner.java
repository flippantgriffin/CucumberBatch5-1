package CukesRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json",// Generate report
        "junit:target/cucumber.json",
        "rerun:target/rerun.txt"}, //RERUN WILL HELP US TO RUN THE FAILED CASES AND WE WILL RUN THEM
        //BY USING RERUNNER CLASS.
        features = "src/test/resources",
        glue="StepDefinition",
        tags="  @TEC-2050 or  @TEC-2003", // its used for grouping purposeses
        dryRun = false // false shows all the unimplemented steps
)

public class Runner {





}
