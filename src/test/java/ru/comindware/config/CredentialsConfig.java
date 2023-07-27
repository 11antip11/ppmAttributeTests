package ru.comindware.config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {

    String loginProject();
    String passwordProject();
    String fioProject();
    String loginDirector();
    String passwordDirector();
    String fioDirector();
    String loginRukovoditel();
    String passwordRukovoditel();
    String fioRukovoditel();
}