package com.oanda.select;

import com.oanda.base.BaseWeb;
import com.oanda.pages.CurrentConvertPage;
import com.oanda.pages.Currency;
import com.oanda.pages.Percent;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SelectCurrencyTest extends BaseWeb {

    @Test
    @Story("Checking that user can change currency and percent.")
    public void testSelectData() {
        new CurrentConvertPage()
                .navigateToUrl("URL")
                .checkTitlePage("TITLE")
                .selectPercent(Percent.TWO)
                .selectCurrencyQuote(Currency.EUR)
                .checkExistingField("EUR")
                .selectCurrencyBase(Currency.CAD)
                .checkRequiredField("CAD");
    }
}
