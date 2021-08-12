package salesforce.ui.pages;

import salesforce.ui.pages.legalentity.*;

import static core.config.LoadEnvironmentFile.getTheSalesforceVersion;

public class AppPageFactory {

    private static String version = getTheSalesforceVersion();

    public static LegalEntitiesPageAbstract getLegalEntitiesPage() {
        if ("classic".equals(version)) {
            return new LegalEntitiesClassicVersion();
        }
        return new LegalEntitiesLightningVersion();
    }

    public static NewLegalEntityPageAbstract getNewLegalEntityPage() {
        if ("classic".equals(version)) {
            return new NewLegalEntityClassicVersion();
        }
        return new NewLegalEntityLightningVersion();
    }

    public static LegalEntityPageAbstract getLegalEntityPage() {
        if ("classic".equals(version)) {
            return new LegalEntityClassicVersion();
        }
        return new LegalEntityLightningVersion();
    }

}
