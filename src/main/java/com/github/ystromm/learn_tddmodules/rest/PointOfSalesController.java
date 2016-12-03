package com.github.ystromm.learn_tddmodules.rest;

import com.github.ystromm.learn_tddmodules.pos.PointOfSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pos")
public class PointOfSalesController {
    private final PointOfSales pointOfSales;

    @Autowired
    public PointOfSalesController(PointOfSales pointOfSales) {
        this.pointOfSales = pointOfSales;
    }

    @RequestMapping
    public DisplayDTO getDisplay() {
        return DisplayDTO.of("");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public DisplayDTO onBarcode(@RequestBody BarcodeDTO barcodeDTO) {
        return DisplayDTO.of("Blah");
    }
}
