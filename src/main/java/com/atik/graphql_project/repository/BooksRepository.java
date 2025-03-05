package com.atik.graphql_project.repository;

import com.atik.graphql_project.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {

}
