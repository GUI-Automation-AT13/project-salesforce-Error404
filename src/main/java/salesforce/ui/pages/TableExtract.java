/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import salesforce.ui.TableRegister;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.selenium.MyWebDriverManager.getWebDriverManager;

public class TableExtract {

    private String tableHeaders = "div.slds-cell-fixed span.slds-truncate";
    private String tableRow = "//th//a[@title='%s']/../../..//*[contains(@class,'slds-truncate')]";

    /**
     * Gets the table of the feature with the required element.
     *
     * @param map    provided map
     * @param entity to obtain table.
     * @return Map<String, String>
     */
    public Map<String, String> getFeatureTable(final String entity, final Map<String, String> map) {
        List<WebElement> tableHeadersList = getWebDriverManager().getDriver()
                .findElements(By.cssSelector(tableHeaders));
        List<WebElement> headersList = new ArrayList<>();
        for (WebElement element : tableHeadersList) {
            if (!element.getText().isEmpty() && element.getText() != null) {
                headersList.add(element);
            }
        }
        String uniqueValue = obtainUniqueValue(entity);
        List<WebElement> valuesList = getWebDriverManager().getDriver()
                .findElements(By.xpath(String.format(tableRow, uniqueValue)));
        return buildTable(headersList, valuesList);
    }

    /**
     * Builds the table of the feature.
     *
     * @param headers a list with the headers.
     * @param values  a list with the values of a row.
     * @return a map.
     */
    private Map<String, String> buildTable(final List<WebElement> headers, final List<WebElement> values) {
        if (headers.size() == values.size()) {
            Map<String, String> table = new HashMap<>();
            for (int i = 0; i < headers.size(); i++) {
                table.put(headers.get(i).getText().trim(), values.get(i).getText().trim());
            }
            return table;
        }
        return null;
    }

    /**
     * Converts a list to map.
     *
     * @param tableList a list<String>.
     * @return Map<String, String>.
     */
    public Map<String, String> convertToMap(final List<String> tableList) {
        int keyPosition = tableList.size() / 2;
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < keyPosition; i++) {
            map.put(tableList.get(i), tableList.get(i + keyPosition));
        }
        return map;
    }

    /**
     * Obtains the unique value of a entity.
     *
     * @param entity the entity to obtain the value.
     * @return the unique value of the entity.
     */
    private String obtainUniqueValue(final String entity) {
        if (entity.equals("LegalEntities")) {
            return TableRegister.getMapValue("LEGALENTITY_NAME");
        }
        if (entity.equals("Products")) {
            return TableRegister.getMapValue("PRODUCT_NAME");
        }
        return "No value";
    }

    /**
     * Builds the actual map.
     *
     * @param map    the map obtained from the scenario.
     * @return a Map<String, String>.
     */
    public Map<String, String> buildActualTable(final Map<String, String> map) {
        Map<String, String> actualMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            actualMap.put(entry.getKey(), TableRegister.getMapValue(entry.getValue()));
        }
        return actualMap;
    }
}
