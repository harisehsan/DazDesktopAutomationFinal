package member.msite;

import cucumber.api.CucumberOptions;

/**
 * Created by admin.son.ton on 1/17/18.
 *
 *
 */

@CucumberOptions(
        features = {"src/test/java/member/msite/features"},
        tags = {"@Test12312321"},
        glue = {"member.msite.step_definitions"})
public class MsiteRunner extends _base.TestRunner {}
