/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.urls;

public enum SalesforceClassicUrl {
    CASES("500"),
    LEGAL_ENTITIES("0fw"),
    PRODUCTS("01t"),
    OPPORTUNITY("006");

    private final String url;

    SalesforceClassicUrl(final String enumUrl) {
        this.url = String.format(FeatureUrl.FEATURE_URL_CLASSIC.getUrl(), enumUrl);
    }

    /**
     * Gets the web site URL.
     *
     * @return a String with the url
     */
    public String getUrl() {
        return url;
    }
}
