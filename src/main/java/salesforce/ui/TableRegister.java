package salesforce.ui;

import java.util.HashMap;
import java.util.Map;

public class TableRegister {

    private static Map<String, String> map = new HashMap<>();

    /**
     * Gets a value of the map.
     * @param key a string with the key.
     * @return a string with the value.
     */
    public static String getMapValue(final String key) {
        return map.get(key);
    }

    /**
     * Adds values to the map.
     * @param key the key of the value.
     * @param value the value.
     */
    public static void addMapValues(final String key, final String value) {
        map.put(key, value);
    }

    /**
     * Cleans the map.
     */
    public static void cleanMap() {
        map.clear();
    }
}
