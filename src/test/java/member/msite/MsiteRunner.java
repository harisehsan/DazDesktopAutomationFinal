package member.msite;

import base.BaseTestRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/member/msite/features"},
        tags = {"@addaddresspclzd"},
        glue = {"member.msite.step_definitions"},
        plugin = {"pretty",
                "io.qameta.allure.cucumber2jvm.AllureCucumber2Jvm",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"
        })
public class MsiteRunner extends BaseTestRunner {

    @Test
    public void test(){
        System.out.println(123);
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }
}