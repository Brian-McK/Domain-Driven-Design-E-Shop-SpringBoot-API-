package Infrastructure.Persistence.Converters;

import Domain.Customers.CustomerId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class CustomerIdConverter implements AttributeConverter<CustomerId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(CustomerId customerId) {
        return customerId != null ? customerId.getValue() : null;
    }

    @Override
    public CustomerId convertToEntityAttribute(UUID uuid) {
        return uuid != null ? new CustomerId(uuid) : null;
    }
}