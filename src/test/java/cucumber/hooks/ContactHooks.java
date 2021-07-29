package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.api.SalesforceApiResponse;
import salesforce.entities.Contact;

public class ContactHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Contact contact;
    final String contactName = "Frank";
    final String contactLastName = "Castle";

    public ContactHooks(ApiRequestBuilder requestBuilder, ApiResponse apiResponse, Contact contact) {
        this.requestBuilder = requestBuilder;
        this.apiResponse = apiResponse;
        this.contact = contact;
    }

    @Before(value = "@CreateContact")
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
        contact.setId(apiResponse.getBody(SalesforceApiResponse.class).getId());
    }

    @After(value = "@DeleteContact", order = 1)
    public void deleteAContact() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Contact/{contactID}")
                .addPathParams("contactID", contact.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
