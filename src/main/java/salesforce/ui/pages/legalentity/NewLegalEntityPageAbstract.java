package salesforce.ui.pages.legalentity;

import salesforce.entities.LegalEntity;
import salesforce.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Set;

public abstract class NewLegalEntityPageAbstract extends BasePage {

    public NewLegalEntityPageAbstract() {
        waitForPageToLoad();
    }

    @Override
    protected void waitForPageToLoad() {
    }

    protected abstract LegalEntityPageAbstract clickSaveBtn();

    protected abstract HashMap<String, Runnable> buildMap(LegalEntity legalEntity);

    /**
     * Creates the legal entity map.
     *
     * @param fields      Set<string> with the keys.
     * @param legalEntity to obtain the values to be set.
     * @return LegalEntityPageAbstract.
     */
    public LegalEntityPageAbstract createLegalEntity(final Set<String> fields, final LegalEntity legalEntity) {
        HashMap<String, Runnable> map = buildMap(legalEntity);
        fields.forEach(field -> map.get(field).run());
        return clickSaveBtn();
    }

}
