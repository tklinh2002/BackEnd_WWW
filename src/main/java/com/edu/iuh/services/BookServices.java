package com.edu.iuh.services;

import com.edu.iuh.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookServices {
    Book findOneById(String id);

    Book add(Book book);

    Book deleteById(String id);

    Book update(Book book);

    List<Book> findBooksByBookTitleContainsIgnoreCase(String bookTitle);

    List<Book> findBooksByBookIdBetween(String low, String high);

    Book findBookByBookTitleIgnoreCase(String bookTitle);

    Page<Book> findBookByBookTitleIgnoreCaseWithPageable(String bookTitle, Pageable pageable);

    List<Book> find10Books(int offset);

    boolean deleteBookByBookTitle(String title);
    int countBook();
    List<Book> searchBooksByBookTitle(String bookTitle);
    Integer countBookInCategory(String categoryId);
    Integer countAuthorBook(String authorId);
    Integer countSupplierBook(String supplierId);
    Integer countPublisherBook(String publisherId);
    Book findBookByBookId(String bookId);
}