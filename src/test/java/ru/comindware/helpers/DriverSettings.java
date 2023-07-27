package ru.comindware.helpers;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.comindware.config.App;


public class DriverSettings {
    public static void configure() {
        Configuration.browser = App.config.browser();
        Configuration.browserVersion = App.config.browserVersion();
        Configuration.browserSize = App.config.browserSize();
        RestAssured.baseURI = App.config.baseUrl();
        Configuration.baseUrl = App.config.baseUrl();
        Configuration.timeout = 60000;
//        open(Configuration.baseUrl);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");



        if (App.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);
            Configuration.remote = App.config.remoteDriverUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
