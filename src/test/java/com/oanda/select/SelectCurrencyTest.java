package com.oanda.select;

import com.oanda.base.BaseWeb;
import com.oanda.pages.CurrentConvertPage;
import com.oanda.pages.Currency;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SelectCurrencyTest extends BaseWeb {

    @Test
    @Story("Checking that user can change currency.")
    public void testSelectData() {
        new CurrentConvertPage()
                .navigateToUrl("URL")
                .checkTitlePage("TITLE")
                .selectCurrencyQuote(Currency.EUR)
                .checkExistingField("EUR")
                .selectCurrencyBase(Currency.CAD)
                .checkRequiredField("CAD");
    }
}
