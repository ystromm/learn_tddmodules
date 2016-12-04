package com.github.ystromm.learn_tddmodules.client.ebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/*
 ID: 947185260,
 Title: "Head First PHP & MySQL",
 Description: "If you're ready to create web pages more complex than what you can build with HTML and CSS, Head First PHP & MySQL is the ultimate learning guide to building dynamic, database-driven websites using PHP and MySQL. Packed with real-world examples, this ...",
 Image: "http://s.it-ebooks-api.info/3/head_first_php__mysql.jpg",
 isbn: "9780596006303"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@Setter(AccessLevel.NONE)
public class Book {
    private int ID;
    private String Title;
    private String Description;
    private String Image;
    private String isbn;
}
