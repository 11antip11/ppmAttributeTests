package ru.comindware.config;

import org.aeonbits.owner.ConfigFactory;

public class App {
    public static AppConfig config = ConfigFactory.create(AppConfig.class, System.getProperties());
    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }
}
