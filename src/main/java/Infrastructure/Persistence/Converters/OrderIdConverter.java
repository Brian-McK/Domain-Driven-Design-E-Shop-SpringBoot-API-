package Infrastructure.Persistence.Converters;

import Domain.Orders.OrderId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class OrderIdConverter implements AttributeConverter<OrderId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(OrderId orderId) {
        return orderId != null ? orderId.getValue() : null;
    }

    @Override
    public OrderId convertToEntityAttribute(UUID uuid) {
        return uuid != null ? new OrderId(uuid) : null;
    }
}
