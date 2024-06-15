package Domain.Products;

import Infrastructure.Config.AppConfig;

import java.util.Objects;

/**
 * Represents a Stock Keeping Unit (SKU).
 */
public final class Sku {

    // A constant for the default length of a valid SKU.
    private static final int DEFAULT_LENGTH = AppConfig.getSkuLength();

    private final String value;

    private Sku(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the SKU.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Factory method to create a new Sku instance if the provided value is valid.
     *
     * @param value the SKU value to validate and use for the new Sku instance
     * @return a new Sku instance if the value is valid; otherwise, null
     */
    public static Sku create(String value) {
        return isValidSku(value) ? new Sku(value) : null;
    }

    /**
     * Validates if the provided SKU (Stock Keeping Unit) is valid.
     *
     * @param value the SKU value to validate
     * @return true if the SKU is valid; otherwise, false
     */
    private static boolean isValidSku(String value) {
        return value != null && value.length() == DEFAULT_LENGTH;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sku sku)) return false;
        return Objects.equals(value, sku.value);
    }

    @Override
    public String toString() {
        return "Sku{" +
                "value='" + value + '\'' +
                '}';
    }
}
