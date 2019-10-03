package com.oanda.waiters;

import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;


/**
 * The class Conditions.
 */
public class Conditions {

    /**
     * Method should have.
     *
     * @param element the element
     * @param text    the text
     */
    public static void shouldHave(WebElement element, String text) {
        assertEquals(element.getText(), text);
    }
}
