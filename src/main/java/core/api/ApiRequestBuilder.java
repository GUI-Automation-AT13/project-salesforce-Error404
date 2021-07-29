/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

import io.restassured.http.Header;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiRequestBuilder implements IBuilder {
    private String baseUri;
    private String endpoint;
    private String body;
    private String token;
    private Enum<ApiMethod> method;
    private List<Header> headers;
    private Map<String, String> queryParams;
    private Map<String, String> pathParms;

    public ApiRequestBuilder() {
        this.headers = new ArrayList<>();
        this.queryParams = new HashMap<>();
        this.pathParms = new HashMap<>();
    }

    /**
     * Adds Base uri in the request builder.
     *
     * @param newBaseUri Base of url.
     * @return Request builder with base uri.
     */
    public ApiRequestBuilder addBaseUri(final String newBaseUri) {
        this.baseUri = newBaseUri;
        return this;
    }

    /**
     * Adds End point in the request builder.
     *
     * @param newEndpoint end point of the feature.
     * @return Request builder with end point.
     */
    public ApiRequestBuilder addEndpoint(final String newEndpoint) {
        this.endpoint = newEndpoint;
        return this;
    }

    /**
     * Adds Body in the request builder.
     *
     * @param newBody body of the dates.
     * @return Request builder with body.
     */
    public ApiRequestBuilder addBody(final String newBody) {
        this.body = newBody;
        return this;
    }

    /**
     * Adds Token in the request builder.
     *
     * @param newToken a String with the token
     * @return Request builder with token
     */
    public ApiRequestBuilder addToken(final String newToken) {
        this.token = newToken;
        return this;
    }

    /**
     * Adds Method in the request builder.
     *
     * @param newMethod an Enum with the method name
     * @return Request builder with Method
     */
    public ApiRequestBuilder addMethod(final Enum<ApiMethod> newMethod) {
        this.method = newMethod;
        return this;
    }

    /**
     * Adds Header in the request builder.
     *
     * @param header a String with the header name
     * @param value a String with the header value
     * @return Request builder with Header
     */
    public ApiRequestBuilder addHeader(final String header, final String value) {
        headers.add(new Header(header, value));
        return this;
    }

    /**
     * Adds Query params in the request builder.
     *
     * @param param a String with the param name
     * @param value a String with the param value
     * @return Request builder with Query params
     */
    public ApiRequestBuilder addQueryParams(final String param, final String value) {
        queryParams.put(param, value);
        return this;
    }

    /**
     * Adds Path params in the request builder.
     *
     * @param param a String with the param name
     * @param value a String with the value
     * @return Request builder with Path params
     */
    public ApiRequestBuilder addPathParams(final String param, final String value) {
        pathParms.put(param, value);
        return this;
    }

    /**
     * Clears Path Params.
     *
     * @return path params empty
     */
    public ApiRequestBuilder clearPathParams() {
        pathParms.clear();
        return this;
    }

    /**
     * Sets the body.
     *
     * @param newBody a String with the new body
     */
    public void setBody(final String newBody) {
        this.body = newBody;
    }

    /**
     * Builds the api request with provided values.
     *
     * @return the api request
     */
    @Override
    public ApiRequest build() {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setBaseUri(this.baseUri);
        apiRequest.setEndpoint(this.endpoint);
        apiRequest.setBody(this.body);
        apiRequest.setToken(this.token);
        apiRequest.setMethod(this.method);
        apiRequest.addHeaders(this.headers);
        apiRequest.addQueryParams(this.queryParams);
        apiRequest.addPathParams(this.pathParms);
        return apiRequest;
    }

}
