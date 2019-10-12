package com.oanda.waiters;

import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;


/**
 * The class Conditions.
 */
public class Conditions {

    /**
     * The default constructor.
     */
    public Conditions() {
        super();
        //empty
        return;
    }

    /**
     * Method should have.
     *
     * @param element the element.
     * @param text    the text.
     */
    public static void shouldHave(final WebElement element, final String text) {
        assertEquals(element.getText(), text);
    }
}
