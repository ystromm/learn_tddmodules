package com.github.ystromm.learn_tddmodules.client.ebook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class SearchResultTest {

    public static final String JSON = "{\"Error\":\"0\",\"Time\":0.0204,\"Total\":\"93\",\"Page\":1,\"Books\":[{\"ID\":3398759608,\"Title\":\"MySQL Stored Procedure Programming\",\"SubTitle\":\"Building High-Performance Web Applications in MySQL\",\"Description\":\"MySQL Stored Procedure Programming covers a lot of ground. The book starts with a thorough introduction to stored procedures programming and functions, covering the fundamentals of data types, operators, and using SQL in stored procedures. You'll lea ...\",\"Image\":\"http://s.it-ebooks-api.info/3/mysql_stored_procedure_programming.jpg\",\"isbn\":\"9780596100896\"},{\"ID\":924371675,\"Title\":\"High Availability MySQL Cookbook\",\"SubTitle\":\"Over 50 simple but incredibly effective recipes focusing on different methods of achieving high availability for MySQL databases\",\"Description\":\"This book covers all the major techniques available for increasing availability of your MySQL databases. It demonstrates how to design, implement, troubleshoot and manage a highly available MySQL setup using any one of several techniques, which are s ...\",\"Image\":\"http://s.it-ebooks-api.info/14/high_availability_mysql_cookbook.jpg\",\"isbn\":\"9781847199942\"},{\"ID\":1470937288,\"Title\":\"MySQL for Python\",\"SubTitle\":\"Integrate the flexibility of Python and the power of MySQL to boost the productivity of your applications\",\"Description\":\"Python is a dynamic programming language, which is completely enterprise ready, owing largely to the variety of support modules that are available to extend its capabilities. In order to build productive and feature-rich Python applications, we need ...\",\"Image\":\"http://s.it-ebooks-api.info/14/mysql_for_python.jpg\",\"isbn\":\"9781849510189\"},{\"ID\":573588234,\"Title\":\"MySQL 5.1 Plugin Development\",\"SubTitle\":\"Extend MySQL to suit your needs with this unique guide into the world of MySQL plugins\",\"Description\":\"MySQL has introduced a Plugin API with its latest version u2013 a robust, powerful, and easy way of extending the server functionality with loadable modules on the fly. But until now anyone wishing to develop a plugin would almost certainly need to dig ...\",\"Image\":\"http://s.it-ebooks-api.info/14/mysql_5.1_plugin_development.jpg\",\"isbn\":\"9781849510608\"},{\"ID\":3440654429,\"Title\":\"Learning MySQL and MariaDB\",\"SubTitle\":\"Heading in the Right Direction with MySQL and MariaDB\",\"Description\":\"If you're a programmer new to databases - or just new to MySQL and its community-driven variant, MariaDB - you've found the perfect introduction. This hands-on guide provides an easy, step-by-step approach to installing, using, and maintaining these ...\",\"Image\":\"http://s.it-ebooks-api.info/3/learning_mysql_and_mariadb.jpg\",\"isbn\":\"9781449362904\"},{\"ID\":2144150505,\"Title\":\"Understanding MySQL Internals\",\"SubTitle\":\"Discovering and Improving a Great Database\",\"Description\":\"Although MySQL's source code is open in the sense of being publicly available, it's essentially closed to you if you don't understand it. This book provides a comprehensive tour of MySQL 5 that shows you how to figure out the inner-workings of this p ...\",\"Image\":\"http://s.it-ebooks-api.info/3/understanding_mysql_internals.jpg\",\"isbn\":\"9780596009571\"},{\"ID\":947185260,\"Title\":\"Head First PHP & MySQL\",\"Description\":\"If you're ready to create web pages more complex than what you can build with HTML and CSS, Head First PHP & MySQL is the ultimate learning guide to building dynamic, database-driven websites using PHP and MySQL. Packed with real-world examples, this ...\",\"Image\":\"http://s.it-ebooks-api.info/3/head_first_php__mysql.jpg\",\"isbn\":\"9780596006303\"},{\"ID\":1286933964,\"Title\":\"MySQL High Availability\",\"SubTitle\":\"Tools for Building Robust Data Centers\",\"Description\":\"Server bottlenecks and failures are a fact of life in any database deployment, but they don't have to bring everything to a halt. MySQL provides several features that can protect you from outages, whether you're running directly on the hardware, on v ...\",\"Image\":\"http://s.it-ebooks-api.info/3/mysql_high_availability.jpg\",\"isbn\":\"9780596807306\"},{\"ID\":4094128166,\"Title\":\"MySQL Pocket Reference, 2nd Edition\",\"SubTitle\":\"SQL Functions and Utilities\",\"Description\":\"This handy pocket reference gives you instant reminders on how to use important MySQL functions, especially in conjunction with key parts of the LAMP open source infrastructure. MySQL is so rich in features that no administrator or programmer can sta ...\",\"Image\":\"http://s.it-ebooks-api.info/3/mysql_pocket_reference_second_edition.jpg\",\"isbn\":\"9780596514266\"},{\"ID\":4031564144,\"Title\":\"High Performance MySQL, 2nd Edition\",\"SubTitle\":\"Optimization, Backups, Replication, and More\",\"Description\":\"High Performance MySQL is the definitive guide to building fast, reliable systems with MySQL. Written by noted experts with years of real-world experience building very large systems, this book covers every aspect of MySQL performance in detail, and ...\",\"Image\":\"http://s.it-ebooks-api.info/3/high_performance_mysql_second_edition.jpg\",\"isbn\":\"9780596101718\"}]}";

    @Test
    public void fromJson() throws IOException {
        System.out.println(new ObjectMapper().readValue(JSON, SearchResult.class));
    }

    @Test
    public void asJson() throws IOException {
        System.out.println(new ObjectMapper().writer().writeValueAsString(SearchResult.builder().Page(1).build()));
    }


}