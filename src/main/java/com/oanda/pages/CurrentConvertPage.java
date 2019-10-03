package com.oanda.pages;

import com.oanda.base.AbstractPage;
import com.oanda.waiters.WaitCondition;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.oanda.utils.PropertiesReader.loadPropertyName;

/**
 * The class Current convert page.
 */
public class CurrentConvertPage extends AbstractPage {

    /**
     * The constant QUOTE_CODE. This is css selector for ui automation script.
     */
    private static final By QUOTE_CODE = By.cssSelector("span[id='quote_currency_code']");

    /**
     * The constant BASE_CODE. This is css selector for ui automation script.
     */
    private static final By BASE_CODE = By.cssSelector("span[id='base_currency_code']");

    /**
     * The constant PERCENT. This is css selector for ui automation script.
     */
    private static final By PERCENT = By.cssSelector("div[id='interbank_rate'] input");

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
     * Method Check title page current convert page.
     *
     * @param titleName the title name.
     * @return the current convert page.
     */
    public CurrentConvertPage checkTitlePage(final String titleName) {
        Assert.assertEquals(getWindowTitle(), loadPropertyName(titleName));
        return this;
    }

    /**
     * Method Check existing field current convert page.
     *
     * @param currentCurrency the current currency.
     * @return the current convert page.
     */
    public CurrentConvertPage checkExistingField(final String currentCurrency) {
        final WaitCondition waitCondition = new WaitCondition();
        Assert.assertEquals(waitCondition.waitForVisibilityOfElementLocatedBy(QUOTE_CODE).getText(), currentCurrency);
        return this;
    }

    /**
     * Method Check required field current convert page.
     *
     * @param currentCurrency the current currency.
     * @return the current convert page.
     */
    public CurrentConvertPage checkRequiredField(final String currentCurrency) {
        final WaitCondition waitCondition = new WaitCondition();
        Assert.assertEquals(waitCondition.waitForVisibilityOfElementLocatedBy(BASE_CODE).getText(), currentCurrency);
        return this;
    }


    /**
     * Method Check interbank rate current convert page.
     *
     * @param bankPercent the bank percent.
     * @return the current convert page.
     */
    public CurrentConvertPage checkInterbankRate(final String bankPercent) {
        final WaitCondition waitCondition = new WaitCondition();
        Assert.assertEquals(waitCondition.waitForVisibilityOfElementLocatedBy(PERCENT).getAttribute("value"), bankPercent);

        return this;
    }

    @Override
    public void test() {
    }
}
