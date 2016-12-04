package com.github.ystromm.learn_tddmodules.pos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
public class Display {
    private String text = "";

    public void setPrice(Price price) {
        text = "SEK " + price.getPrice();
    }

    public void setProductNotFoundMessage(Barcode barcode) {
        text = "Produkten finns inte: " + barcode.getValue();
    }

    public void setBadBarcodeMessage() {
        text = "Konstig streckkod!";
    }

    public void clear() {
        text = "";
    }
}
