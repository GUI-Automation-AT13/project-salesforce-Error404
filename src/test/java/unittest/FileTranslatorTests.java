package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import salesforce.utils.FileTranslator;

public class FileTranslatorTests {

    @Test
    public void translateWordThroughKey() {
        FileTranslator fileTranslator = new FileTranslator();
        String feature = "Products";
        String key = "productDescription";
        String actual = fileTranslator.translateValue(feature, key);
        String expected = "Product Description";
        Assert.assertEquals(actual, expected);
    }
}
