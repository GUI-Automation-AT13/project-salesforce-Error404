package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import salesforce.utils.CaseAttributeNameAdapter;

public class CaseAttributeNameAdapterTests {

    @Test
    public void returnValueOfExistingKey() {
        String keyValue = "estado";
        String expected = "status";
        String actual = CaseAttributeNameAdapter.getCaseAttributeName(keyValue);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void returnValueOfNonExistingKey() {
        String keyValue = "noexistent";
        String expected = "noexistent";
        String actual = CaseAttributeNameAdapter.getCaseAttributeName(keyValue);
        Assert.assertEquals(actual, expected);
    }
}
