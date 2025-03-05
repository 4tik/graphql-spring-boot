package com.atik.graphql_project.serviceImpl;

import com.atik.graphql_project.model.Books;
import com.atik.graphql_project.repository.BooksRepository;
import com.atik.graphql_project.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BooksRepository booksRepository;

    @Override
    public List<Books> getBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Books getById(Long id) {
        return booksRepository.findById(id).orElse(null);
    }
}
