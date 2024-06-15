package Infrastructure.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            System.out.printf("Exception: %s%n", ex.getMessage());
        }
    }

    public static int getSkuLength() {
        String skuLengthStr = properties.getProperty("base.sku-length");
        if (skuLengthStr == null) {
            throw new IllegalArgumentException("Property 'base.sku-length' not found");
        }
        try {
            return Integer.parseInt(skuLengthStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Property 'base.sku-length' is not a valid integer");
        }
    }
}
