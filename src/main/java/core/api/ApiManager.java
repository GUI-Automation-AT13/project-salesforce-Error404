/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class ApiManager {
    private ApiManager() { }

    /**
     * Executes a ApiRequest without body.
     *
     * @param apiRequest Contains all data of request.
     * @param apiResponse after execution of request.
     */
    public static void execute(final ApiRequest apiRequest, final ApiResponse apiResponse) {
        Response response = buildRequest(apiRequest).request(apiRequest.getMethod().name(),
                apiRequest.getEndpoint());
        apiResponse.setResponse(response);
    }

    /**
     * Executes a ApiRequest without body without log.
     *
     * @param apiRequest Contains all data of request.
     * @param apiResponse after execution of request.
     */
    public static void executeWithoutLog(final ApiRequest apiRequest,
                                         final ApiResponse apiResponse) {
        Response response = buildRequestWithoutLog(apiRequest)
                .request(apiRequest.getMethod().name(), apiRequest.getEndpoint());
        apiResponse.setResponse(response);
    }

    /**
     * Builds a RequestSpecification.
     *
     * @param apiRequest Contains all data of request.
     * @return RequestSpecification.
     */
    private static RequestSpecification buildRequest(final ApiRequest apiRequest) {
        return given()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .baseUri(apiRequest.getBaseUri())
                .contentType(ContentType.JSON)
                .log()
                .all();
    }

    /**
     * Builds a RequestSpecification without log.
     *
     * @param apiRequest Contains all data of request.
     * @return RequestSpecification without log.
     */
    private static RequestSpecification buildRequestWithoutLog(final ApiRequest apiRequest) {
        return given()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getQueryParams())
                .pathParams(apiRequest.getPathParams())
                .baseUri(apiRequest.getBaseUri())
                .contentType(ContentType.JSON);
    }

    /**
     * Executes a ApiRequest with body.
     *
     * @param apiRequest Contains all data of request
     * @param apiResponse contains all the api response data
     */
    public static void executeWithBody(final ApiRequest apiRequest, final ApiResponse apiResponse) {
        Response response = buildRequest(apiRequest)
                .body(apiRequest.getBody())
                .request(apiRequest.getMethod().name(), apiRequest.getEndpoint());
        apiResponse.setResponse(response);
    }
}
