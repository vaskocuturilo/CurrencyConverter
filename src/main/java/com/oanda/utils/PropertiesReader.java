package com.oanda.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;


/**
 * The class Properties reader.
 */
public final class PropertiesReader {
    /**
     * Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesReader.class);

    /**
     * Constant PROPERTIES.
     */
    private static final Properties PROPERTIES;

    /**
     * Constant PROP_FILE.
     */
    private static final String PROP_FILE = "test.properties";

    /**
     * Default private constructor PropertiesReader.
     */
    private PropertiesReader() {
    }

    static {
        PROPERTIES = new Properties();
        final URL props = ClassLoader.getSystemResource(PROP_FILE);
        try {
            PROPERTIES.load(props.openStream());
        } catch (IOException ex) {

            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(ex.getClass().getName() + "PropertiesReader method");
            }
        }
    }

    /**
     * Method getProperty.
     *
     * @param name String name file.
     * @return Return property
     */
    public static String getProperty(final String name) {

        return PROPERTIES.getProperty(name);
    }

    /**
     * Method loadPropertyName.
     *
     * @param name String name file.
     * @return Return string
     */
    public static String loadPropertyName(final String name) {

        return getProperty(name);
    }
}
