package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesManager {

    private PropertiesManager() { }

    /**
     * Sets the system properties from a specified file.
     */
    public static void setPropertiesFromFile() {
            try {
                final InputStream stream = getPropertiesFromFile();
                Properties properties = System.getProperties();
                properties.load(stream);
                System.setProperties(properties);
            } catch (IOException e) {
                throw new Error("Error setting the properties from file.", e);
            }
    }

    /**
     * Reads a specified file and extracts the properties as a stream.
     * @return {InputSteam} Raw file data as a stream.
     */
    private static InputStream getPropertiesFromFile() {
        try {
            File propertiesFile = new File("config.properties");
            return new FileInputStream(propertiesFile);
        } catch (Exception e) {
            throw new Error("Error reading the properties file.", e);
        }
    }
}
