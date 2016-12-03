package com.github.ystromm.learn_tddmodules.pos;

public class PointOfSales {
    public Price getPrice(Barcode barcode) {
        if (barcode.getValue().equals("1234567890")) {
            return Price.of(37);
        } else {
            return Price.of(73);
        }
    }
}
