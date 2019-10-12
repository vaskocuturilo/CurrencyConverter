package com.oanda.data;

import com.oanda.base.BaseWeb;
import com.oanda.pages.CurrentConvertPage;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class DateAndRateTest extends BaseWeb {
    @Test
    @Story("Check date and rate.")
    public void testCheckDateAndRate() {
        new CurrentConvertPage()
                .navigateToUrl("URL")
                .checkTitlePage("TITLE")
                .selectData()
                .selectWeekend()
                .checkInterbankRate("0%");
    }
}
