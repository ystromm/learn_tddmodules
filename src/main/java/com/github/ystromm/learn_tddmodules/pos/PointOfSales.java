package com.github.ystromm.learn_tddmodules.pos;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class PointOfSales {

    private static final Price RAIN_HAT_PRICE = Price.of(73);
    private static final Price UMBRELLA_PRICE = Price.of(37);
    private static final Barcode UMBRELLA_BARCODE = Barcode.of("1234567890");
    private static final Barcode RAIN_HAT_BARCODE = Barcode.of("2222222222");
    private static final Map<Barcode, Price> pricelist = ImmutableMap.of(
            UMBRELLA_BARCODE, UMBRELLA_PRICE,
            RAIN_HAT_BARCODE, RAIN_HAT_PRICE);

    public Optional<Price> getPrice(Barcode barcode) {
        if (barcode.getValue().equals(UMBRELLA_BARCODE.getValue())) {
            return Optional.of(UMBRELLA_PRICE);
        } else if (barcode.getValue().equals(RAIN_HAT_BARCODE.getValue())) {
            return Optional.of(RAIN_HAT_PRICE);
        } else {
            return Optional.empty();
        }
    }
}
