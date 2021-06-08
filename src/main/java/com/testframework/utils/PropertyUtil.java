package com.testframework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private static Properties prop;
    private static FileInputStream inputStream;
    private static final String CONFIG_PATH = ("src/main/resources/config.properties").replace("/", File.separator);

    private static void readConfigFile() {
        try {
            prop = new Properties();
            prop.load(inputStream = new FileInputStream(CONFIG_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        readConfigFile();
        return prop.getProperty(key);
    }
}
