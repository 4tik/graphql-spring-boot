package com.atik.graphql_project.controller;

import com.atik.graphql_project.model.Books;
import com.atik.graphql_project.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public List<Books> books(){
        return bookService.getBooks();
    }

    @QueryMapping
    public Books getById(@Argument Long id){
        return bookService.getById(id);
    }
}
