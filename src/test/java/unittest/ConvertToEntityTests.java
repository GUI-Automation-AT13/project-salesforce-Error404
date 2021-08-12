package unittest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;
import salesforce.entities.Product;
import salesforce.utils.ConverterToEntity;
import java.util.HashMap;
import java.util.Map;

public class ConvertToEntityTests {

    @Test
    public void convertsMapToProductEntity() throws JsonProcessingException {
        ConverterToEntity converterToEntity = new ConverterToEntity();
        Map<String, String> table = new HashMap<String, String>();
        table.put("Name", "product to test");
        Product expectedProduct = new Product();
        Product actualProduct = converterToEntity.convertMapToEntity(table, Product.class);
        Assert.assertEquals(actualProduct.getClass(), expectedProduct.getClass());
    }
}
