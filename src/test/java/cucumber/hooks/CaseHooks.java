/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import io.cucumber.java.After;
import salesforce.entities.Case;
import static salesforce.api.petitions.CasePetition.deleteCase;

public class CaseHooks {
    private Case newCase;

    public CaseHooks(final Case aNewCase) {
        this.newCase = aNewCase;
    }

    @After
    public void deleteACase() {
        if (newCase != null) {
            deleteCase(newCase.getId());
        }
    }
}
