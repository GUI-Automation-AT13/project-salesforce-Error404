package salesforce.ui.pages;

import org.openqa.selenium.By;
import salesforce.entities.LegalEntity;
import salesforce.ui.pages.legalentity.LegalEntityPage;

import java.util.HashMap;
import java.util.Set;

public abstract class NewLegalEntityPageAbstract extends BasePage {

    public NewLegalEntityPageAbstract() {
        waitForPageToLoad();
    }

    @Override
    protected void waitForPageToLoad() {
    }

    /**
     * .
     * @return .
     */
    protected abstract LegalEntityPageAbstract clickSaveBtn();

    protected abstract HashMap<String, Runnable> buildMap(LegalEntity legalEntity);

    /**
     * .
     * @param fields .
     * @param legalEntity .
     * @return .
     */
    public LegalEntityPageAbstract createLegalEntity(final Set<String> fields, final LegalEntity legalEntity) {
        HashMap<String, Runnable> map = buildMap(legalEntity);
        fields.forEach(field -> map.get(field).run());
        return clickSaveBtn();
    }

}
