/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

import io.restassured.response.Response;

public class ApiResponse {

    private Response response;

    public ApiResponse() {
    }

    /**
     * Gets the response.
     *
     * @return an object with the response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Sets the response.
     *
     * @param newResponse an object to set the response
     */
    public void setResponse(final Response newResponse) {
        this.response = newResponse;
    }

    /**
     * Gets the status of the code.
     *
     * @return an int with the status code
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Gets a body.
     *
     * @param cls is type of entity.
     * @param <T> is type of entity.
     * @return Body response as class.
     */
    public <T> T getBody(final Class<T> cls) {
        return response.getBody().as(cls);
    }

    /**
     * Gets the json's path.
     *
     * @param path a String with the url path
     * @return a String with the json's path
     */
    public String getPath(final String path) {
        return response.getBody().jsonPath().getJsonObject(path);
    }
}
