package com.atik.graphql_project.serviceImpl;

import com.atik.graphql_project.bindings.BookPayload;
import com.atik.graphql_project.common.CommonUtil;
import com.atik.graphql_project.model.Books;
import com.atik.graphql_project.repository.BooksRepository;
import com.atik.graphql_project.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        return booksRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Book Not Found."));
    }

    @Override
    public Books create(BookPayload bookPayload) {
        if(bookPayload==null){
            throw new IllegalArgumentException("Input cannot be NULL");
        }

        Books book = Books.builder()
                .title(bookPayload.getTitle())
                .author(bookPayload.getAuthor())
                .price(bookPayload.getPrice())
                .isbn(bookPayload.getIsbn())
                .publisher(bookPayload.getPublisher())
                .publicationDate(CommonUtil.stringToDate(bookPayload.getPublicationDate()))
                .category(bookPayload.getCategory())
                .language(bookPayload.getLanguage())
                .totalPage(bookPayload.getTotalPage())
                .stockQuantity(bookPayload.getStockQuantity())
                .build();
        return booksRepository.save(book);
    }

    @Override
    public Books update(Long id, BookPayload bookPayload) {
        Books book = getById(id);
        book.setTitle(bookPayload.getTitle());
        book.setAuthor(bookPayload.getAuthor());
        book.setPrice(bookPayload.getPrice());
        book.setIsbn(bookPayload.getIsbn());
        book.setPublisher(bookPayload.getPublisher());
        book.setPublicationDate(CommonUtil.stringToDate(bookPayload.getPublicationDate()));
        book.setCategory(bookPayload.getCategory());
        book.setLanguage(bookPayload.getLanguage());
        book.setTotalPage(bookPayload.getTotalPage());
        book.setStockQuantity(bookPayload.getStockQuantity());
        return booksRepository.save(book);
    }

    @Override
    public boolean deleteById(Long id) {
        return booksRepository.findById(id).map(book -> {
            booksRepository.delete(book);
            return true;
        }).orElse(false);
    }
}
