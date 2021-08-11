/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.entities.Contact;
import static core.config.LoadEnvironmentFile.getTheBaseUrlClassic;
import static cucumber.hooks.Hooks.getCreatedToken;

public class ContactHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Contact contact;
    final String contactName = "Frank";
    final String contactLastName = "Castle";
    private static String contactId;

    public ContactHooks(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse,
                        final Contact newContact) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.contact = newContact;
    }

    @Before(value = "@CreateContact")
    public void checkContactCreation() throws JsonProcessingException {
        if (contactId == null) {
            createAContact();
        }
    }

    @Before(value = "not @CreateContact")
    public void checkAccountDeletion() {
        if (contactId != null) {
            deleteAContact();
        }
    }

    /**
     * Creates a contact through API.
     *
     * @throws JsonProcessingException when invalid json provided
     */
    public void createAContact() throws JsonProcessingException {
        contact.setFirstName(contactName);
        contact.setLastName(contactLastName);
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Contact/")
                .addBody(new ObjectMapper().writeValueAsString(contact))
                .addMethod(ApiMethod.POST)
                .build();
        ApiManager.executeWithBody(requestBuilder.build(), apiResponse);
        contactId = apiResponse.getPath("id");
    }

    @After(value = "@DeleteContact", order = 1)
    public void deleteAContact() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Contact/{contactID}")
                .addPathParams("contactID", contactId)
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
        contactId = null;
    }

    /**
     * Deletes a contact.
     */
    public static void deleteContact() {
        if (contactId != null) {
            ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
            ApiResponse response = new ApiResponse();
            apiRequestBuilder
                    .addHeader("Authorization", getCreatedToken())
                    .addBaseUri(getTheBaseUrlClassic())
                    .addEndpoint("/services/data/v52.0/sobjects/Contact/{contactID}")
                    .addPathParams("contactID", contactId)
                    .addMethod(ApiMethod.DELETE)
                    .build();
            ApiManager.execute(apiRequestBuilder.build(), response);
            contactId = null;
        }
    }
}
