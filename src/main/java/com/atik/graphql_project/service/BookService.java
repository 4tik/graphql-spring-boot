package com.atik.graphql_project.service;


import com.atik.graphql_project.model.Books;

import java.util.List;

public interface BookService {
    List<Books> getBooks();
    Books getById(Long id);
}
