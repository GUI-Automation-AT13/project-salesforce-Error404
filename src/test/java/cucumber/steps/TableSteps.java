package cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.ui.pages.TableExtract;
import java.util.Map;
import static salesforce.config.EnvironmentConfig.getSalesforceVersion;

public class TableSteps {

    private Logger logger = LogManager.getLogger(getClass());
    TableExtract tableExtract = new TableExtract();
    private String lightningSkin = "lightning";

    /**
     * Verifies the information given in the table.
     *
     * @param entity  to obtain it's unique value.
     * @param mapData a data table with the values to validate.
     */
    @Then("^The following information should be displayed on the (.*?) table$")
    public void theFollowingInformationShouldBeDisplayedOnTheTable(final String entity, final DataTable mapData) {
        logger.info("=================== Then The created feature should be on table ==========================");
        if (getSalesforceVersion().equals(lightningSkin)) {
            SoftAssert softAssert = new SoftAssert();
            Map<String, String> map = mapData.asMap(String.class, String.class);
            softAssert.assertEquals(tableExtract.buildActualTable(map), tableExtract.getFeatureTable(entity, map));
            softAssert.assertAll();
        }
    }
}
