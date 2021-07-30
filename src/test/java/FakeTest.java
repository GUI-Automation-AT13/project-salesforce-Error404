import org.testng.annotations.Test;
import java.util.Locale;
import java.util.ResourceBundle;

public class FakeTest {
    @Test
    public void test100() {
        System.out.println(ResourceBundle.getBundle("internationalization/i18NCases",
                new Locale("es")).getString("caseOwner"));
        System.out.println(ResourceBundle.getBundle("internationalization/i18NCases",
                new Locale("en")).getString("caseOwner"));
    }
}
