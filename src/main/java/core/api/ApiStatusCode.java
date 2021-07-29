/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.api;

public enum ApiStatusCode {
    OK("OK", 200),
    CREATED("CREATED", 201),
    NO_CONTENT("NO CONTENT", 204),
    BAD_REQUEST("BAD REQUEST", 400),
    FORBIDDEN("FORBIDDEN", 403),
    NOT_FOUND("NOT FOUND", 404),
    INTERNAL_SERVER_ERROR("INTERNAL SERVER ERROR", 500);
    private String name;
    private int value;

    ApiStatusCode(final String newName, final int newValue) {
        this.name = newName;
        this.value = newValue;
    }

    /**
     * Gets the value of the status code.
     *
     * @return an int with the status code
     */
    public int getValue() {
        return value;
    }
}
