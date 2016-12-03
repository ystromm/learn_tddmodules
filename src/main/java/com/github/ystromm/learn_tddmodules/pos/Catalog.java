package com.github.ystromm.learn_tddmodules.pos;

import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.Map;
import java.util.Optional;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Catalog {

    private static final Barcode RAIN_HAT_BARCODE = Barcode.of("2");
    private static final Barcode UMBRELLA_BARCODE = Barcode.of("1");
    private static final Price UMBRELLA_PRICE = Price.of(99.95);
    private static final Price RAIN_HAT_PRICE = Price.of(24.95);
    private final Map<Barcode, Price> barcodePriceMap;

    public static Catalog rainClothesCatalog() {
        return new Catalog(ImmutableMap.of(
                RAIN_HAT_BARCODE, RAIN_HAT_PRICE,
                UMBRELLA_BARCODE, UMBRELLA_PRICE
        ));
    }

    Optional<Price> getPrice(Barcode barcode) {
        return Optional.ofNullable(barcodePriceMap.get(barcode));
    }
}
