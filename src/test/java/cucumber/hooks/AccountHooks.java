/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.Before;
import salesforce.entities.Account;
import static salesforce.api.petitions.AccountPetition.createAccount;
import static salesforce.api.petitions.AccountPetition.deleteAccount;

public class AccountHooks {
    private Account account;
    private String accountName = "Punisher";
    private static String accountId;

    public AccountHooks(final Account newAccount) {
        this.account = newAccount;
    }

    @Before(value = "@CreateAccount")
    public void checkAccountCreation() throws JsonProcessingException {
        if (accountId == null) {
            account.setName(accountName);
            accountId = createAccount(account);
        }
    }

    @Before(value = "not @CreateAccount")
    public void checkAccountDeletion() {
        if (accountId != null) {
            deleteAccount(accountId);
            accountId = null;
        }
    }

    /**
     * Gets the account id.
     *
     * @return a String with the id
     */
    public static String getAccountId() {
        return accountId;
    }
}
