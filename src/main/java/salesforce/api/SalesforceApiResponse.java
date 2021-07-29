/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.api;

import java.util.List;

public class SalesforceApiResponse {
    private String id;
    private boolean success;
    private List<Object> errors;

    /**
     * Gets Salesforce API response's id.
     *
     * @return a String with the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets Salesforce API response's id.
     *
     * @param newId a String with the id to set
     */
    public void setId(final String newId) {
        this.id = newId;
    }

    /**
     * Gets if the Salesforce API response is successful.
     *
     * @return a boolean with the answer
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Sets the Salesforce API response's is success status.
     *
     * @param newSuccess a boolean with the success status to set
     */
    public void setSuccess(final boolean newSuccess) {
        this.success = newSuccess;
    }

    /**
     * Gets a list of errors from the Salesforce API response.
     *
     * @return a list with the errors
     */
    public List<Object> getErrors() {
        return errors;
    }

    /**
     * Sets a list of errors to the Salesforce API response.
     *
     * @param newErrors a list with the errors to set
     */
    public void setErrors(final List<Object> newErrors) {
        this.errors = newErrors;
    }
}
