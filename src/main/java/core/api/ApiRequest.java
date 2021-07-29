/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

import io.restassured.http.Header;
import io.restassured.http.Headers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiRequest {
    private String baseUri;
    private String endpoint;
    private String body;
    private String token;
    private Enum<ApiMethod> method;
    private List<Header> headers;
    private Map<String, String> queryParams;
    private Map<String, String> pathParams;

    public ApiRequest() {
        headers = new ArrayList<>();
        queryParams = new HashMap<>();
        pathParams = new HashMap<>();
    }

    /**
     * Gets the base Uri.
     *
     * @return a String with the base Uri
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Sets the base Uri.
     *
     * @param newBaseUri a String with the value to set
     */
    public void setBaseUri(final String newBaseUri) {
        this.baseUri = newBaseUri;
    }

    /**
     * Gets the endpoint.
     *
     * @return a String with the endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the endpoint.
     *
     * @param newEndpoint a String with the value to set
     */
    public void setEndpoint(final String newEndpoint) {
        this.endpoint = newEndpoint;
    }

    /**
     * Gets the body.
     *
     * @return a String with the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param newBody a String with the value to set
     */
    public void setBody(final String newBody) {
        this.body = newBody;
    }

    /**
     * Gets the token.
     *
     * @return a String with the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token.
     *
     * @param newToken a String with the value to set
     */
    public void setToken(final String newToken) {
        this.token = newToken;
    }

    /**
     * Gets the Api method.
     *
     * @return a String with the Api method
     */
    public Enum<ApiMethod> getMethod() {
        return method;
    }

    /**
     * Sets the Api method.
     *
     * @param newMethod a String with the value to set
     */
    public void setMethod(final Enum<ApiMethod> newMethod) {
        this.method = newMethod;
    }

    /**
     * Adds the headers.
     *
     * @param newHeaders a List with the headers to add
     */
    public void addHeaders(final List<Header> newHeaders) {
        this.headers = newHeaders;
    }

    /**
     * Adds the query parameters.
     *
     * @param newQueryParams a Map with the query parameters to add
     */
    public void addQueryParams(final Map<String, String> newQueryParams) {
        this.queryParams = newQueryParams;
    }

    /**
     * Adds the path parameters.
     *
     * @param newPathParams a Map with the path parameters to add
     */
    public void addPathParams(final Map<String, String> newPathParams) {
        this.pathParams = newPathParams;
    }

    /**
     * Removes all the values added to the path params Map.
     */
    public void clear() {
        pathParams.clear();
    }

    /**
     * Gets the headers.
     *
     * @return an Object with the headers
     */
    public Headers getHeaders() {
        return new Headers(headers);
    }

    /**
     * Gets the query parameters.
     *
     * @return a Map of Strings with the query parameters
     */
    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    /**
     * Gets the path parameters.
     *
     * @return a Map of Strings with the path parameters
     */
    public Map<String, String> getPathParams() {
        return pathParams;
    }
}
