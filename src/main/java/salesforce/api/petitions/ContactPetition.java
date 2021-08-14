/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.api.petitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import salesforce.entities.Contact;

import static core.config.LoadEnvironmentFile.getTheBaseUrlClassic;

public class ContactPetition {

    /**
     * Creates a Contact.
     *
     * @param contact the contact to set.
     * @param contactName the name of the contact.
     * @param contactLastName the last name of the contact.
     * @param contactId the contact id.
     * @param requestBuilder the request builder.
     * @param apiResponse the api response.
     * @throws JsonProcessingException the exception to be thrown.
     */
    public void createContact(final Contact contact, final String contactName, final String contactLastName,
                              String contactId, final ApiRequestBuilder requestBuilder,
                              final ApiResponse apiResponse) throws JsonProcessingException {
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

    /**
     * Deletes a Contact.
     *
     * @param requestBuilder the request builder.
     * @param apiResponse the api response.
     * @param contactId the id of the contact.
     */
    public void deleteAContact(final ApiRequestBuilder requestBuilder, final ApiResponse apiResponse,
                               String contactId) {
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
     * Delete Contact.
     *
     * @param contactId the id of the contact.
     * @param token the token generated.
     */
    public static void deleteContact(String contactId, final String token) {
        if (contactId != null) {
            ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
            ApiResponse response = new ApiResponse();
            apiRequestBuilder
                    .addHeader("Authorization", token)
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
