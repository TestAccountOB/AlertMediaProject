package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/AlertMedia.feature",
        glue = "Steps",
        dryRun = false,
        monochrome = true,
        tags = "@Regression",
        plugin = {"pretty",
                "html:target/cucumber.html", "json:target/cucumber.json", "rerun:target/failed.txt"}


)
public class TestRunnerOlena {
}
