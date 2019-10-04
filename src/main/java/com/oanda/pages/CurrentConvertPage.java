package com.oanda.pages;

import com.oanda.base.AbstractPage;
import com.oanda.waiters.Conditions;
import com.oanda.waiters.WaitCondition;
import lombok.experimental.ExtensionMethod;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.oanda.utils.PropertiesReader.loadPropertyName;

/**
 * The class Current convert page.
 */
@ExtensionMethod(Conditions.class)
public class CurrentConvertPage extends AbstractPage {

    /**
     * The constant VALUE.
     */
    private static final String VALUE = "value";

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
     * The constant CURRENT_DATE. This is css selector for ui automation script.
     */
    private static final By CURRENT_DATE = By.cssSelector("input[id='end_date_input']");

    /**
     * The constant RESULT. This is css selector for ui automation script.
     */
    private static final By RESULT = By.cssSelector("input[id='base_amount_input']");

    /**
     * The constant RESULT. This is css selector for ui automation script.
     */
    private static final By AMOUNT = By.cssSelector("td[id='sellMyCurrencyGet']");


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
        Assert.assertEquals(waitCondition.waitForVisibilityOfElementLocatedBy(PERCENT).getAttribute(VALUE), bankPercent);

        return this;
    }

    /**
     * Method checkDefaultCalculatedField.
     *
     * @return the current convert page
     */
    public CurrentConvertPage checkDefaultCalculatedField() {
        final WaitCondition waitCondition = new WaitCondition();
        Assert.assertEquals(waitCondition.waitForVisibilityOfElementLocatedBy(AMOUNT).getText(), "you get " + getResultFromCalculated() + " EUR");
        return this;
    }

    /**
     * Method getResultFromCalculated .
     *
     * @return the result from calculated amount field int
     */
    public String getResultFromCalculated() {
        return findElement(RESULT).getAttribute(VALUE);
    }

    @Override
    public void test() {
    }
}
