package com.oanda.pages;

import com.oanda.base.AbstractPage;
import com.oanda.waiters.Conditions;
import com.oanda.waiters.WaitCondition;
import lombok.experimental.ExtensionMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
    private static final By SELECT_WEEKEND = By.xpath("//td[@class='calendarWeekend'][1]");

    /**
     * The constant QUOTE_AMOUNT. This is css selector for ui automation script.
     */
    private double DEFAULT_QUOTE = 0;


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
    public CurrentConvertPage enterAmountToField(String amount) {
        final WaitCondition waitCondition = new WaitCondition();
        WebElement quoteFiledElement = waitCondition.waitForVisibilityOfElementLocatedBy(QUOTE_AMOUNT);
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
    public CurrentConvertPage checkAmountOfCalculation(Double defaultAmount) {
        String leftData = getResultFromCalculated();
        leftData = leftData.replace(" ", "");
        leftData = leftData.replace(',', '.');
        double rightData = DEFAULT_QUOTE * defaultAmount;
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
        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SELECT_DATE).click();
        waitCondition.waitForVisibilityOfElementLocatedBy(SELECT_CALENDAR);

        return this;
    }


    public CurrentConvertPage selectWeekend() {

        WaitCondition waitCondition = new WaitCondition();
        waitCondition.waitForVisibilityOfElementLocatedBy(SELECT_WEEKEND).click();

        return this;
    }


    @Override
    public void test() {
    }
}
