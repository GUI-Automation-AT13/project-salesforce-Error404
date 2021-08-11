/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils;

import salesforce.config.EnvironmentConfig;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class EnvironmentInitialConfig {

    public EnvironmentInitialConfig() { }

    /**
     * Creates a .env file with required fields.
     */
    public void createEnvFile() {
        try {
            FileWriter envOutput = new FileWriter(".env");
            envOutput.write(setVariables());
            envOutput.close();
        } catch (IOException e) {
            System.out.println("File can't be created, " + e.getMessage());
        }
    }

    /**
     * Sets the String with all the environment variables.
     *
     * @return a String with all the env variables.
     */
    private String setVariables() {
        String variables = "";
        Field[] declaredVariable = EnvironmentConfig.class.getDeclaredFields();
        for (Field variable: declaredVariable) {
            if (getVariable(variable) != null) {
                variables += getVariable(variable) + "=\n";
            }
        }
        variables += "LOGIN_URL=https://login.salesforce.com/\n"
                + "EXPLICIT_WAIT_TIME=10\n"
                + "IMPLICIT_WAIT_TIME=20\n"
                + "BROWSER=CHROME\n"
                + "LANGUAGE=en\n"
                + "SALESFORCE_VERSION=lightning";
        return variables;
    }

    /**
     * Gets a variable from the field of a specific class.
     *
     * @param declaredVar the field of a class.
     * @return declared variable as String.
     */
    private String getVariable(final Field declaredVar) {
        String[] arrayOfField = declaredVar.toString().split("[.]");
        if (!arrayOfField[arrayOfField.length - 1].matches(".*[a-z].*")) {
            return arrayOfField[arrayOfField.length - 1];
        }
        return null;
    }
}
