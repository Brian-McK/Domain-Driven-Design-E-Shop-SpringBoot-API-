package Shared;

import java.math.BigDecimal;

/**
 * Represents a monetary value with a currency and an amount.
 *
 * @param currency the currency of the monetary value
 * @param amount the amount of the monetary value
 */
public record Money(String currency, BigDecimal amount) {
}
