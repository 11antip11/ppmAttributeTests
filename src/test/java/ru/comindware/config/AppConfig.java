package ru.comindware.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/app.properties")
public interface AppConfig extends Config{
    @DefaultValue("http://192.168.1.33")
    String apiUrl();
    @DefaultValue("http://192.168.1.33/#RecordType/oa.169/Forms/form.11373")
    String baseUrl();
    @DefaultValue("chrome")
    String browser();
    @DefaultValue("110.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}
