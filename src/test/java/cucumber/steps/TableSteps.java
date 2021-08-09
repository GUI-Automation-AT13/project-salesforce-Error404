package cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.TableExtract;

import java.util.Map;

public class TableSteps {
    private Logger logger = LogManager.getLogger(getClass());

    @Then("The following information should be displayed on the table")
    public void theFollowingInformationShouldBeDisplayedOnTheTable(final DataTable mapData) {
        logger.info("=================== Then The created feature should be on table ==========================");
        SoftAssert softAssert = new SoftAssert();
        Map<String, String> map = mapData.asMap(String.class, String.class);
        TableExtract tableExtract = new TableExtract();
        Map<String, String> expectedMap = tableExtract.getFeatureTable(map);
        softAssert.assertEquals(map, expectedMap);
        softAssert.assertAll();
    }
}
