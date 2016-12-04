package com.github.ystromm.learn_tddmodules.rest;

import com.github.ystromm.learn_tddmodules.pos.Barcode;
import com.github.ystromm.learn_tddmodules.pos.Display;
import com.github.ystromm.learn_tddmodules.pos.PointOfSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pos/")
public class PointOfSalesController {
    private final PointOfSales pointOfSales;
    private final Display display;

    @Autowired
    public PointOfSalesController(PointOfSales pointOfSales, Display display) {
        this.pointOfSales = pointOfSales;
        this.display = display;
    }

    @RequestMapping(path = "display")
    public DisplayDTO getDisplay() {
        return DisplayDTO.of(display.getText());
    }

    @RequestMapping(path = "barcode", method = RequestMethod.POST)
    public DisplayDTO onBarcode(@RequestBody BarcodeDTO barcodeDTO) {
        pointOfSales.onBarcode(Barcode.of(barcodeDTO.getValue()));
        return getDisplay();
    }

    @RequestMapping(path = "sell", method = RequestMethod.POST)
    public DisplayDTO onSell() {
        pointOfSales.sell();
        return getDisplay();
    }

}
