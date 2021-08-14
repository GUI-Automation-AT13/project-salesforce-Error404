/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import io.cucumber.java.After;
import salesforce.entities.LegalEntity;
import static salesforce.api.petitions.LegalEntityPetition.deleteLegalEntity;

public class LegalEntityHooks {
    private LegalEntity legalEntity;

    public LegalEntityHooks(final LegalEntity newLegalEntity) {
        this.legalEntity = newLegalEntity;
    }

    @After(value = "@DeleteLegalEntity", order = 2)
    public void deleteALegalEntity() {
        deleteLegalEntity(legalEntity);
    }
}
