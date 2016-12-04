package com.github.ystromm.learn_tddmodules.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PointOfSales {

    private final Display display;
    private final Catalog catalog;
    private double accumulator;

    @Autowired
    public PointOfSales(Display display) {
        this(display, Catalog.rainClothesCatalog());
    }

    public PointOfSales(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(Barcode barcode) {
        if (barcode.getValue().isEmpty()) {
            display.setBadBarcodeMessage();
        } else {
            final Optional<Price> price = catalog.getPrice(barcode);
            if (price.isPresent()) {
                display.setPrice(price.get());
                accumulator += price.get().getPrice();
            } else {
                display.setProductNotFoundMessage(barcode);
            }
        }
    }

    private static final Barcode RAIN_HAT_BARCODE = Barcode.of("2");
    private static final Barcode UMBRELLA_BARCODE = Barcode.of("1");


    public void sell() {
        if (accumulator != 0.0) {
            display.setPrice(Price.of(accumulator));
            accumulator = 0.0;
        }
        else {
            display.clear();
        }
    }
}
