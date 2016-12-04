package com.github.ystromm.learn_tddmodules.client.ebook;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class EbookClientTest {

    @Test
    public void xxxx() {
        System.out.println(new EbookClient(new RestTemplate()).search("mysql"));
    }

}