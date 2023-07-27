package ru.comindware.helpers;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class Locators {

    private enum LocatorsType {
        id,
        name,
        className,
        tagName,
        linkText,
        css,
        xpath
    }


    private static final Properties locators;
    static {
        locators = new Properties();
        FileInputStream fis = null;
        try {
            // fis = new FileInputStream("src\\test\\java\\properties\\locators.properties");//InputStream is =Locators.class.getResourceAsStream("/locators.properties");
            fis = new FileInputStream("src/test/resources/config/locators.properties");//InputStream is =Locators.class.getResourceAsStream("/locators.properties");       //линукс

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try{

            locators.load(fis);
        }
        catch (Exception e) {
            System.out.println("Error reading from property file");
        }
    }
    public static By getLocator(String locator) throws Exception {
        String value = locators.getProperty(locator);

        String[] result = value.split("=",2);
        LocatorsType locatorType = LocatorsType.valueOf(result[0]);
        String selector = result[1];
        switch (locatorType) {
            case id -> {
                return By.id(selector);
            }
            case name -> {
                return By.name(selector);
            }
            case className -> {
                return By.className(selector);
            }
            case tagName -> {
                return By.tagName(selector);
            }
            case linkText -> {
                return By.linkText(selector);
            }
            case css -> {
                return By.cssSelector(selector);
            }
            case xpath -> {
                return By.xpath(selector);
            }
            default -> throw new Exception("No such locator type");
        }
    }
}