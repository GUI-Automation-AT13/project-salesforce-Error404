/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.utils;

public final class AdaptStringToAttribute {
    private AdaptStringToAttribute() {
    }

    /**
     * Changes a String from salesforce and changes it to attributes format.
     *
     * @param string to change
     * @return converted string
     */
    public static String changeFieldName(final String string) {
        return (string.substring(0, 1).toLowerCase() + string.substring(1))
                .replace(" ", "").replace("/", "");
    }
}
