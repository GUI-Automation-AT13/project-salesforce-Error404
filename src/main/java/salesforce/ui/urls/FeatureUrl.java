/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.urls;

public enum FeatureUrl {
    FEATURE_URL_LIGHTNING("lightning/o/%s/list?filterName=Recent"),
    FEATURE_URL_CLASSIC("%s/o");

    private final String url;

    FeatureUrl(final String enumUrl) {
        this.url = enumUrl;
    }

    /**
     * Gets the web site default feature URL.
     *
     * @return a String with the feature url
     */
    public String getUrl() {
        return url;
    }
}
