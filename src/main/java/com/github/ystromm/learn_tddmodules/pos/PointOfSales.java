package com.github.ystromm.learn_tddmodules.pos;

import java.util.Optional;

public class PointOfSales {
    public Optional<Price> getPrice(Barcode barcode) {
        if (barcode.getValue().equals("1234567890")) {
            return Optional.of(Price.of(37));
        } else if (barcode.getValue().equals("2222222222")) {
            return Optional.of(Price.of(73));
        } else {
            return Optional.empty();
        }
    }
}
