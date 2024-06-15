package Infrastructure.Persistence.Converters;

import Domain.Products.ProductId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class ProductIdConverter implements AttributeConverter<ProductId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(ProductId productId) {
        return productId != null ? productId.getValue() : null;
    }

    @Override
    public ProductId convertToEntityAttribute(UUID uuid) {
        return uuid != null ? new ProductId(uuid) : null;
    }
}

