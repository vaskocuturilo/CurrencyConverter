package com.oanda;

import com.oanda.base.BaseWeb;
import com.oanda.pages.CurrentConvertPage;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class ConvertCurrentTest extends BaseWeb {

    @Test
    @Story("Check current convert on page '{0}'")
    public void testCheckCurrentConvert() {
        new CurrentConvertPage()
                .navigateToUrl("URL")
                .checkTitlePage("TITLE")
                .checkExistingField("USD")
                .checkRequiredField("EUR")
                .checkInterbankRate("0%")
                .checkCurrentDate("","","");
    }
}
