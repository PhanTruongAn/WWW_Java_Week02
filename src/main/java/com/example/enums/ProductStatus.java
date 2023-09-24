package com.example.enums;

public enum ProductStatus {

    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATE(-1);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
