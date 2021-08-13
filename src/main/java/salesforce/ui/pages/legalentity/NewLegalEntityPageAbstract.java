/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

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

    protected abstract LegalEntityPageAbstract clickSaveBtn() throws InterruptedException;

    protected abstract HashMap<String, Runnable> buildMap(LegalEntity legalEntity);

    /**
     * Creates the legal entity map.
     *
     * @param fields      Set<string> with the keys.
     * @param legalEntity to obtain the values to be set.
     * @return LegalEntityPageAbstract.
     */
    public LegalEntityPageAbstract createLegalEntity(final Set<String> fields, final LegalEntity legalEntity) throws InterruptedException {
        HashMap<String, Runnable> map = buildMap(legalEntity);
        fields.forEach(field -> map.get(field).run());
        return clickSaveBtn();
    }

}
