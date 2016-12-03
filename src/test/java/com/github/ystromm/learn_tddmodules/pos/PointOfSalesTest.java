package com.github.ystromm.learn_tddmodules.pos;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PointOfSalesTest {

    public static final Barcode UMBRELLA_BARCODE = Barcode.of("1234567890");
    public static final Barcode RAIN_HAT_BARCODE = Barcode.of("2222222222");
    public static final Price RAIN_HAT_PRICE = Price.of(73);
    public static final Price UMBRELLA_PRICE = Price.of(37);

    @Test
    public void entering_umbrella_barcode_should_return_umbrella_price() {
        assertThat(getPrice(UMBRELLA_BARCODE), equalTo(UMBRELLA_PRICE));
    }

    @Test
    public void entering_rain_hat_barcode_should_return_rain_hat_price() {
        assertThat(getPrice(RAIN_HAT_BARCODE), equalTo(RAIN_HAT_PRICE));
    }

    private static Price getPrice(Barcode barcode) {
        return new PointOfSales().getPrice(barcode);
    }
}
