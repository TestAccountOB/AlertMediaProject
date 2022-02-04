package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /**
     * Use this method to read Properties.
     *
     * @param filePath Pass path to the file.
     */
    static Properties prop;

    //this method will read any property file
    public static Properties readProperties(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * Use this method to retrieve single value based on the specified key.
     *
     * @param key Pass key in String format.
     */

    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }

}
