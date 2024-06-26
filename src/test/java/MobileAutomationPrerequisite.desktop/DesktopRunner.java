package MobileAutomationPrerequisite.desktop;

import _base.TestRunner;
import cucumber.api.CucumberOptions;

/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/MobileAutomationPrerequisite.desktop/features"},
        tags = {"@verify_third_item_from_pdp_properties"},
        glue = {"MobileAutomationPrerequisite.desktop.step_definitions","homepage.desktop.step_definitions","checkout.desktop.step_definitions"})
public class DesktopRunner extends TestRunner{}

