package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"stepdef.ui"},
        tags = "@Ui",
        plugin = {
                "pretty",
                "html:target/cucumber/html/",
                "json:target/json/file.json",
        },
        dryRun = false
)

public class RunTempUi {

}
