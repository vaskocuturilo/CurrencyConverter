package com.oanda.environment;

import java.util.Locale;

/**
 * The class Environment.
 */
public final class Environment {

    /**
     * The default constructor.
     */
    private Environment() {
    }

    /**
     * Method isCheckOSSystem.
     * If method return true, that is automation scripts to run on OS Unix or Linux.
     * If method return false, that is automation scripts to run on OS Windows or Mac.
     *
     * @return the boolean
     */
    public static boolean isCheckOperationSystem() {

        final String operationSystem = System.getProperty("os.name").toLowerCase(Locale.ROOT);

        return (operationSystem.contains("nix") || operationSystem.contains("nux"));
    }


}
