package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import salesforce.utils.AdaptStringToAttribute;

public class AdaptStringToAttributeTests {
    @Test
    public void changesTheText() {
        String value = "text/to change";
        String actual = AdaptStringToAttribute.changeFieldName(value);
        String expected = "texttochange";
        Assert.assertEquals(actual, expected);
    }
}
