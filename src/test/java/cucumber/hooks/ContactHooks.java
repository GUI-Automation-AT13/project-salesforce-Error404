/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.api.petitions.ContactPetition;
import salesforce.entities.Contact;
import static cucumber.hooks.Hooks.getCreatedToken;

public class ContactHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Contact contact;
    final String contactName = "Frank";
    final String contactLastName = "Castle";
    private static String contactId;
    private ContactPetition contactPetition = new ContactPetition();

    public ContactHooks(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse,
                        final Contact newContact) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.contact = newContact;
    }

    @Before(value = "@CreateContact")
    public void checkContactCreation() throws JsonProcessingException {
        if (contactId == null) {
            contactPetition
                    .createContact(contact, contactName, contactLastName, contactId, requestBuilder, apiResponse);
        }
    }

    @Before(value = "not @CreateContact")
    public void checkAccountDeletion() {
        if (contactId != null) {
            deleteAContact();
        }
    }

    @After(value = "@DeleteContact", order = 1)
    public void deleteAContact() {
        contactPetition.deleteAContact(requestBuilder, apiResponse, contactId);
    }

    /**
     * Deletes a contact.
     */
    public static void deleteContact() {
        ContactPetition.deleteContact(contactId, getCreatedToken());
    }
}
