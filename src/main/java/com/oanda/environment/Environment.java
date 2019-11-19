package com.oanda.environment;

public class Environment {


    public static boolean isCheckOperationSystem() {

        String operationSystem = System.getProperty("os.name").toLowerCase();

        return (operationSystem.contains("nix") || operationSystem.contains("nux"));
    }


}
