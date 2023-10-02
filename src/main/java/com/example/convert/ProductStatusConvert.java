package com.example.convert;

import com.example.enums.EmployeeStatus;
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
        if (integer == 1)
            return ProductStatus.ACTIVE;
        if (integer == 0)
            return ProductStatus.IN_ACTIVE;
        if (integer == -1)
            return ProductStatus.TERMINATE;
        return null;
    }
}
