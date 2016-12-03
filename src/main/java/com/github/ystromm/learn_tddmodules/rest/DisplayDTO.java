package com.github.ystromm.learn_tddmodules.rest;

import lombok.*;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
public class DisplayDTO {
    private String text;
}
