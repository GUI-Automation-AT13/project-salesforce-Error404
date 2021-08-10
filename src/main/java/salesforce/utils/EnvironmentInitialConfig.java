/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils;

import java.io.FileWriter;

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the String with all the environment variables.
     *
     * @return a String with all the env variables.
     */
    private String setVariables() {
        String variables = "";
        EnvironmentFieldsEnum[] baseEnum = EnvironmentFieldsEnum.class.getEnumConstants();
        for (EnvironmentFieldsEnum envVar: baseEnum) {
            variables += envVar + "=\n";
        }
        variables += "LOGIN_URL=https://login.salesforce.com/\n"
                + "EXPLICIT_WAIT_TIME=10\n"
                + "IMPLICIT_WAIT_TIME=20\n"
                + "BROWSER=CHROME\n"
                + "LANGUAGE=en";
        return variables;
    }

    /*public static void main(String[] args) {
        Field[] fields = LoadEnvironmentFile.class.getFields();
        Field[] declared = LoadEnvironmentFile.class.getDeclaredFields();
        System.out.println("Printing");
        System.out.println(fields.length);
        for (int i = 0; i< fields.length; i++) {
            System.out.println(fields[i]);
        }
        System.out.println("Printing");
        for (int i = 0; i< declared.length; i++) {
            System.out.println(declared[i]);
        }
    }*/

    /*public static void main(String[] args) {
        String content = "BASE_URL=\nUSER=";
        try {
            FileWriter output = new FileWriter(".env");
            output.write(content);
            output.close();
        } catch(Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        EnvironmentFieldsEnum[] baseEnum = EnvironmentFieldsEnum.class.getEnumConstants();
        for(int i = 0; i<baseEnum.length; i++) {
            System.out.println(baseEnum[i]);
        }
    }*/
}
