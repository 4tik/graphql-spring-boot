package com.atik.graphql_project.bindings;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookPayload {
    private String title;
    private String author;
    private Float price;
    private String isbn;
    private String publisher;
    private String publicationDate;
    private String category;
    private String language;
    private Integer totalPage;
    private Integer stockQuantity;
}
