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
import salesforce.entities.Account;

public class AccountHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Account account;
    final String accountName = "Punisher";

    public AccountHooks(ApiRequestBuilder requestBuilder, ApiResponse apiResponse, Account account) {
        this.requestBuilder = requestBuilder;
        this.apiResponse = apiResponse;
        this.account = account;
    }

    @Before(value = "@CreateAccount")
    public void createAnAccount() throws JsonProcessingException {
        account.setName(accountName);
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Account/")
                .addBody(new ObjectMapper().writeValueAsString(account))
                .addMethod(ApiMethod.POST)
                .build();
        ApiManager.executeWithBody(requestBuilder.build(), apiResponse);
        account.setId(apiResponse.getBody(SalesforceApiResponse.class).getId());
    }

    @After(value = "@DeleteAccount", order = 0)
    public void deleteAnAccount() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Account/{accountID}")
                .addPathParams("accountID", account.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
