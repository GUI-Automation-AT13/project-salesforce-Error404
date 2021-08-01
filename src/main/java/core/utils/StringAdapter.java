/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import org.apache.commons.lang3.StringUtils;

public class StringAdapter {

    /**
     * Replace characters with accents and 'ñ' to supported characters.
     *
     * @param string a text to replace
     * @return a String with the characters replaced
     */
    public static String replaceSpecialCharacters(final String string) {
        return StringUtils.stripAccents(string);
    }
}
