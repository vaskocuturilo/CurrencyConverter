package com.oanda.pages;

import com.oanda.base.AbstractPage;
import org.testng.Assert;

import static com.oanda.utils.PropertiesReader.loadPropertyName;

/**
 * The class Current convert page.
 */
public class CurrentConvertPage extends AbstractPage {

    /**
     * The default constructor.
     */
    public CurrentConvertPage() {
        super();
        //empty
        return;
    }

    /**
     * Navigate ti url current convert page.
     *
     * @param url the url.
     * @return the current convert page.
     */
    public CurrentConvertPage navigateToUrl(final String url) {
        navigateWebBrowser().to(loadPropertyName(url));
        return this;
    }

    /**
     * Check title page current convert page.
     *
     * @param titleName the title name.
     * @return the current convert page.
     */
    public CurrentConvertPage checkTitlePage(final String titleName) {
        Assert.assertEquals(getWindowTitle(), loadPropertyName(titleName));
        return this;
    }

    @Override
    public void test() {
    }
}
