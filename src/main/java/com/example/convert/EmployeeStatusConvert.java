package com.example.convert;

import com.example.enums.EmployeeStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class EmployeeStatusConvert implements AttributeConverter<EmployeeStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus employeeStatus) {
        if (employeeStatus == null) {
            return null;
        }
        return employeeStatus.getValue();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer integer) {
        if (integer == 1)
            return EmployeeStatus.ACTIVE;
        if (integer == 0)
            return EmployeeStatus.IN_ACTIVE;
        if (integer == -1)
            return EmployeeStatus.DELETE;
        return null;
    }
}
