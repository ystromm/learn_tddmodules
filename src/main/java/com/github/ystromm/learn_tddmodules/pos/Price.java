package com.github.ystromm.learn_tddmodules.pos;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(staticName = "of")
public class Price {
    private final double price;
}
