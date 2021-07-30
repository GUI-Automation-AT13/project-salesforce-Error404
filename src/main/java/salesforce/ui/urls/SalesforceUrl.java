/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.urls;

public enum SalesforceUrl {
//    CASES("Case"),
//    LEGAL_ENTITIES("LegalEntity"),
//    PRODUCTS("Product2"),
//    OPPORTUNITIES("Opportunity"),
    CASES("lightning/o/Case/list?filterName=Recent"),
    LEGAL_ENTITIES("lightning/o/LegalEntity/list?filterName=Recent"),
    PRODUCTS("lightning/o/Product2/list?filterName=Recent"),
    OPPORTUNITIES("lightning/o/Opportunity/list?filterName=Recent"),
    FEATURE_URL("lightning/o/%s/list?filterName=Recent");

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
