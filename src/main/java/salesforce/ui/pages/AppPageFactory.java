/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages;

import salesforce.ui.pages.legalentity.*;

import static core.config.LoadEnvironmentFile.getTheSalesforceVersion;

public class AppPageFactory {

    private static String version = getTheSalesforceVersion();

    /**
     * Gets the legal entities page.
     *
     * @return the correct legal entities page instance.
     */
    public static LegalEntitiesPageAbstract getLegalEntitiesPage() {
        if ("classic".equals(version)) {
            return new LegalEntitiesClassicVersion();
        }
        return new LegalEntitiesLightningVersion();
    }

    /**
     * Gets the new legal entity page.
     *
     * @return the correct new legal entities page instance.
     */
    public static NewLegalEntityPageAbstract getNewLegalEntityPage() {
        if ("classic".equals(version)) {
            return new NewLegalEntityClassicVersion();
        }
        return new NewLegalEntityLightningVersion();
    }

    /**
     * Gets the legal entity page.
     *
     * @return the correct legal entity page instance.
     */
    public static LegalEntityPageAbstract getLegalEntityPage() {
        if ("classic".equals(version)) {
            return new LegalEntityClassicVersion();
        }
        return new LegalEntityLightningVersion();
    }

}
