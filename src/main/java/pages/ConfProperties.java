package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try {
            //указание пути до файла
            fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //обработка возможного исключения (нет файла и т.п.)
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); }
        }
    }

    // return values from file conf.properties
    public static String getPropertyString(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static int getPropertyInt(String key) {
        String strNum = PROPERTIES.getProperty(key);
        int num = Integer.parseInt(strNum);
        return num;
    }
}