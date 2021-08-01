package salesforce.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

/**
 * Converts to entity.
 */
public class ConverterToEntity {
    /**
     * Converts a map to entity.
     *
     * @param table the map to convert.
     * @param entityClass the type of entity class to convert the map.
     * @param <T> any entity
     * @return an entity.
     * @throws JsonProcessingException the exception thrown
     */
    public static <T> T convertMapToEntity(final Map<String, String> table, final Class<T> entityClass)
            throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(table);
        return new ObjectMapper().readValue(json, entityClass);
    }
}
