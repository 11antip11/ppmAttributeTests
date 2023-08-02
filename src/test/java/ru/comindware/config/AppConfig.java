package ru.comindware.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/app.properties")
public interface AppConfig extends Config{
    @DefaultValue("https://test.qa.comindware.net")
    String apiUrl();
    @DefaultValue("https://test.qa.comindware.net/#solutions")
    String baseUrl();
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("115.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}
