package com.example.convert;

import com.example.enums.ProductStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductStatusConvert implements AttributeConverter<ProductStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductStatus productStatus) {
        if(productStatus == null){
        return null;
        }
        return  productStatus.getValue();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer integer) {
        if (integer == null) {
            return null;
        }
       return Stream.of(ProductStatus.values())
               .filter(x -> x.getValue() == integer)
               .findFirst()
               .orElseThrow(IllegalArgumentException::new);
    }
}
