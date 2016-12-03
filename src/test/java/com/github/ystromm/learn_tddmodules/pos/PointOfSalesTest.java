package com.github.ystromm.learn_tddmodules.pos;


import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PointOfSalesTest {

    @Test
    public void entering_barcode1_should_return_price() {
        final Price price = new PointOfSales().getPrice(Barcode.of("1234567890"));
        assertThat(price, equalTo(Price.of(37)));
    }

    @Test
    public void entering_barcode2_should_return_price() {
        final Price price = new PointOfSales().getPrice(Barcode.of("2222222222"));
        assertThat(price, equalTo(Price.of(73)));
    }

}
