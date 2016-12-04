package com.github.ystromm.learn_tddmodules.client.ebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EbookClient {
    private final RestTemplate restTemplate;

    @Autowired
    public EbookClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SearchResult search(String query) {
        final ResponseEntity<SearchResult> forEntity = restTemplate.getForEntity("http://it-ebooks-api.info/v1/search/" + query, SearchResult.class);
        return forEntity.getBody();
    }
}
