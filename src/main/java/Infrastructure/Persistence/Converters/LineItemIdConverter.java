package Infrastructure.Persistence.Converters;

import Domain.Orders.LineItemId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class LineItemIdConverter implements AttributeConverter<LineItemId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(LineItemId lineItemId) {
        return lineItemId != null ? lineItemId.getValue() : null;
    }

    @Override
    public LineItemId convertToEntityAttribute(UUID uuid) {
        return uuid != null ? new LineItemId(uuid) : null;
    }
}
