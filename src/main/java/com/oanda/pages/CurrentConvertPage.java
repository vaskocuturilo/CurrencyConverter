package com.oanda.pages;

import com.oanda.base.AbstractPage;
import com.oanda.waiters.WaitCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static com.oanda.utils.PropertiesReader.loadPropertyName;

/**
 * The class Current convert page.
 */
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
     * The constant RESULT. This is css selector for ui automation script.
     */
    private static final By RESULT = By.cssSelector("input[id='base_amount_input']");

    /**
     * The constant RESULT. This is css selector for ui automation script.
     */
    private static final By AMOUNT = By.cssSelector("td[id='sellMyCurrencyGet']");

    /**
     * The constant QUOTE_AMOUNT. This is css selector for ui automation script.
     */
    private static final By QUOTE_AMOUNT = By.cssSelector("input[id='quote_amount_input']");

    /**
     * The constant SELECT_DATE. This is css selector for ui automation script.
     */
    private static final By SELECT_DATE = By.cssSelector("a[id='end_date_button']");

    /**
     * The constant SELECT_CALENDAR. This is css selector for ui automation script.
     */
    private static final By SELECT_CALENDAR = By.cssSelector("div[class='calendarContainer']");

    /**
     * The constant SELECT_WEEKEND. This is css selector for ui automation script.
     */
    private static final By SELECT_WEEKEND = By.cssSelector("td[class='calendarWeekend']");

    /**
     * The constant QUOTE_CURRENCY. This is css selector for ui automation script.
     */
    private static final By QUOTE_CURRENCY = By.cssSelector("input[id='quote_currency_input']");

    /**
     * The constant BASE_CURRENCY. This is css selector for ui automation script.
     */
    private static final By BASE_CURRENCY = By.cssSelector("input[id='base_currency_input']");

    /**
     * The constant RATE_BANK. This is css selector for ui automation script.
     */
    private static final By RATE_BANK = By.cssSelector("input[id='interbank_rates_input']");
    /**
     * The value defaultQuote. .
     */
    private double defaultQuote = 0.0d;


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


    /**
     * Enter amount to field current convert page.
     *
     * @param amount the amount
     * @return the current convert page
     */
    public CurrentConvertPage enterAmountToField(final String amount) {
        final WaitCondition waitCondition = new WaitCondition();
        final WebElement quoteFiledElement = waitCondition.waitForVisibilityOfElementLocatedBy(QUOTE_AMOUNT);
        quoteFiledElement.clear();
        quoteFiledElement.sendKeys(amount);
        waitCondition.waitForTextToBePresentInElementValueByAttribute(findElement(QUOTE_AMOUNT), amount);
        quoteFiledElement.sendKeys(Keys.ENTER);
        return this;
    }


    /**
     * Check amount of calculation current convert page.
     *
     * @param defaultAmount the default amount.
     * @return the current convert page.
     */
    public CurrentConvertPage checkAmountOfCalculation(final Double defaultAmount) {
        String leftData = getResultFromCalculated();
        leftData = leftData.replace(" ", "");
        leftData = leftData.replace(',', '.');
        double rightData = defaultQuote * defaultAmount;
        rightData = Math.round(rightData * 100.0) / 100.0;
        Assert.assertEquals(Double.parseDouble(leftData), rightData);
        return this;
    }

    /**
     * Select data current convert page.
     *
     * @return the current convert page.
     */
    public CurrentConvertPage selectData() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SELECT_DATE).click();
        waitCondition.waitForVisibilityOfElementLocatedBy(SELECT_CALENDAR);
        return this;
    }


    /**
     * Select weekend current convert page.
     *
     * @return the current convert page.
     */
    public CurrentConvertPage selectWeekend() {
        final WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SELECT_WEEKEND).click();
        return this;
    }

    /**
     * Select currency quote current convert page.
     *
     * @param currency this is value from Enum Currency.
     * @return the current convert page.
     */
    public CurrentConvertPage selectCurrencyQuote(final Currency currency) {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(QUOTE_CURRENCY).sendKeys(String.valueOf(currency.getCurrency()) + Keys.RETURN);

        return this;
    }

    /**
     * Select currency base current convert page.
     *
     * @param currency this is value from Enum Currency.
     * @return the current convert page.
     */
    public CurrentConvertPage selectCurrencyBase(final Currency currency) {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(BASE_CURRENCY).sendKeys(String.valueOf(currency.getCurrency()) + Keys.RETURN);

        return this;
    }

    /**
     * Select percent current convert page.
     *
     * @param percent the percent.
     * @return the current convert page.
     */
    public CurrentConvertPage selectPercent(final Percent percent) {
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(RATE_BANK).sendKeys(String.valueOf(percent.getPercent()) + Keys.ENTER);

        return this;
    }


    @Override
    public void test() {
    }
}
