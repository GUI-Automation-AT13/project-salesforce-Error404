/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.urls;

public enum SalesforceUrl {
    CASES("lightning/o/Case/list?filterName=Recent"),
    LEGALENTITY("lightning/o/LegalEntity/list?filterName=Recent"),
    OPPORTUNITY("lightning/o/Opportunity/list?filterName=Recent");

    private final String url;

    SalesforceUrl(final String enumUrl) {
        this.url = enumUrl;
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
