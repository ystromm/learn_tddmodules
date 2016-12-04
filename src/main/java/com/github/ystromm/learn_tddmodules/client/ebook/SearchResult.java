package com.github.ystromm.learn_tddmodules.client.ebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

/**
 * {
 Error: "0",
 Time: 0.0331,
 Total: "1",
 Page: 1,
 Books: [
 {
 ID: 947185260,
 Title: "Head First PHP & MySQL",
 Description: "If you're ready to create web pages more complex than what you can build with HTML and CSS, Head First PHP & MySQL is the ultimate learning guide to building dynamic, database-driven websites using PHP and MySQL. Packed with real-world examples, this ...",
 Image: "http://s.it-ebooks-api.info/3/head_first_php__mysql.jpg",
 isbn: "9780596006303"
 }
 ]
 }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize()
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter(AccessLevel.NONE)
public class SearchResult {
    // private String Error;
    private String Total;
    private int Page;
    private List<Book> Books;
}
