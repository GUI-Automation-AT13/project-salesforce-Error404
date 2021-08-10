package salesforce.ui.pages;

import java.util.HashMap;

public abstract class LegalEntityPageAbstract extends BasePage {

    @Override
    protected void waitForPageToLoad() {
    }

    public abstract HashMap<String, String> entityMap();

    public abstract String getHeaderEntityNameText();
}
