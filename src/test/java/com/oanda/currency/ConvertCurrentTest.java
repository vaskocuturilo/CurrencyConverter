package com.oanda.currency;

import com.oanda.base.BaseWeb;
import com.oanda.pages.CurrentConvertPage;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class ConvertCurrentTest extends BaseWeb {
    double defaultAmount = 2400;

    @Test
    @Story("Check current convert on page '{0}'")
    public void testCheckCurrentConvert() {
        new CurrentConvertPage()
                .navigateToUrl("URL")
                .checkTitlePage("TITLE")
                .checkExistingField("USD")
                .checkRequiredField("EUR")
                .checkInterbankRate("0%")
                .checkDefaultCalculatedField()
                .enterAmountToField("2400")
                .checkAmountOfCalculation(defaultAmount);
    }


}
