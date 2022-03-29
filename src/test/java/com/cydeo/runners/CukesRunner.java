package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
               // "pretty", //just prints out additional information about the scenario that is being executed
                "html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"

        },
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        dryRun = true,
        tags ="@smoke",
        publish = true //will enable a functionality from cucumber to generate a public link to share someone
)
public class CukesRunner {
}
