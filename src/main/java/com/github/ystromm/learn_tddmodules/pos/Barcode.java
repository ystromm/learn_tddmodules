package com.github.ystromm.learn_tddmodules.pos;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Barcode {
    private final String value;
}
