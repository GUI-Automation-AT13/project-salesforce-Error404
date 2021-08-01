package salesforce.utils;

import java.util.ResourceBundle;
import static core.utils.LoadEnvironmentFile.getLanguage;

public class Translator {
    private static final String I18N_FILE_PATH = "internationalization/i18N%s";

    /**
     * Translates a word through a key.
     *
     * @param feature name file on internationalization folder
     * @param key value on i18N properties file
     * @return a String with the translated word
     */
    public static String translateValue(final String feature, final String key) {
        return ResourceBundle.getBundle(String.format(I18N_FILE_PATH, feature),
                getLanguage()).getString(key);
    }
}
