package com.github.ystromm.learn_tddmodules.pos;


import com.google.common.collect.ImmutableMap;
import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;

public class PointOfSalesTest {

    private static final Barcode UMBRELLA_BARCODE = Barcode.of("1");
    private static final Barcode RAIN_HAT_BARCODE = Barcode.of("2");
    private static final Barcode EMPTY_BARCODE = Barcode.of("");
    private static final Barcode UNKOWN_BARCODE = Barcode.of("FOO");
    private static final Price RAIN_HAT_PRICE = Price.of(24.95);
    private static final Price UMBRELLA_PRICE = Price.of(99.95);

    @Test
    public void productFound() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(RAIN_HAT_BARCODE);
        assertThat(display.getText(), equalTo("SEK " + RAIN_HAT_PRICE.getPrice()));
    }

    @Test
    public void getText_should_return_price_for_rain_hat() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(RAIN_HAT_BARCODE);

        Assertions.assertThat(display.getText()).isEqualTo("SEK " + RAIN_HAT_PRICE.getPrice());
        Assertions.assertThat(display).extracting(Display::getText).contains("SEK " + RAIN_HAT_PRICE.getPrice());
    }

    @Test
    public void anotherProductFound() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(UMBRELLA_BARCODE);
        assertThat(display.getText(), equalTo("SEK " + UMBRELLA_PRICE.getPrice()));
    }

    @Test
    public void productNotFound() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, emptyCatalog());
        pointOfSales.onBarcode(UNKOWN_BARCODE);
        assertThat(display.getText(), equalTo("Produkten finns inte: " + UNKOWN_BARCODE.getValue()));
    }

    @Test
    public void emptyBarcode() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, emptyCatalog());
        pointOfSales.onBarcode(EMPTY_BARCODE);
        assertThat(display.getText(), equalTo("Konstig streckkod!"));
    }

    @Test
    public void scanOneProductAndSell() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(UMBRELLA_BARCODE);
        pointOfSales.sell();
        assertThat(display.getText(), equalTo("SEK " + UMBRELLA_PRICE.getPrice()));
    }

    @Test
    public void scanOneProductAndSellAndScanAnotherProduct() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(UMBRELLA_BARCODE);
        pointOfSales.sell();
        pointOfSales.onBarcode(RAIN_HAT_BARCODE);
        assertThat(display.getText(), equalTo("SEK " + RAIN_HAT_PRICE.getPrice()));
    }

    @Test
    public void scanTwoProducts() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(UMBRELLA_BARCODE);
        pointOfSales.onBarcode(RAIN_HAT_BARCODE);
        assertThat(display.getText(), equalTo("SEK " + RAIN_HAT_PRICE.getPrice()));
    }

    @Test
    public void scanTwoProductsAndSell() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(UMBRELLA_BARCODE);
        pointOfSales.onBarcode(RAIN_HAT_BARCODE);
        pointOfSales.sell();
        assertThat(display.getText(), equalTo("SEK " + (UMBRELLA_PRICE.getPrice()+RAIN_HAT_PRICE.getPrice())));
    }

    @Test
    public void scanOneProductAndSellAndSell() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(UMBRELLA_BARCODE);
        pointOfSales.sell();
        pointOfSales.sell();
        assertThat(display.getText(), emptyString());
    }

    @Test
    public void scanOneProductAndSellAndOneProductAndSell() {
        final Display display = new Display();
        final PointOfSales pointOfSales = new PointOfSales(display, catalogWithRainClothes());
        pointOfSales.onBarcode(UMBRELLA_BARCODE);
        pointOfSales.sell();
        pointOfSales.onBarcode(UMBRELLA_BARCODE);
        pointOfSales.sell();
        assertThat(display.getText(), equalTo("SEK " + UMBRELLA_PRICE.getPrice()));
    }

    private static Catalog catalogWithRainClothes() {
        return Catalog.of(ImmutableMap.of(
                RAIN_HAT_BARCODE, RAIN_HAT_PRICE,
                UMBRELLA_BARCODE, UMBRELLA_PRICE
        ));
    }

    private static Catalog emptyCatalog() {
        return Catalog.of(ImmutableMap.of());
    }
}
