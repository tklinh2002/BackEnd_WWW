package com.edu.iuh.services.impl;

import com.edu.iuh.repositories.BookRepository;
import com.edu.iuh.services.BookServices;
import com.edu.iuh.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServicesImpl implements BookServices {
    private final BookRepository bookRepository;

    public BookServicesImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findOneById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book deleteById(String id) {
        Book book = findOneById(id);
        bookRepository.deleteById(id);
        return book;
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooksByBookTitleContainsIgnoreCase(String bookTitle) {
//        return bookRepository.findBooksByBookTitleContainsIgnoreCase(bookTitle);
        return null;
    }

    public List<Book> findBooksByBookIdBetween(String low, String high) {
        return bookRepository.findBooksByBookIdBetween(low, high);
    }

    public Book findBookByBookTitleIgnoreCase(String bookTitle) {
        return bookRepository.findBookByBookTitleIgnoreCase(bookTitle);
    }

    @Override
    public Page<Book> findBookByBookTitleIgnoreCaseWithPageable(String bookTitle, Pageable pageable) {
        return bookRepository.findBooksByBookTitleContainsIgnoreCase(bookTitle, pageable);
    }

    @Override
    public List<Book> find10Books(int offset) {
        return bookRepository.find10Books(offset);
    }

    @Override
    public boolean deleteBookByBookTitle(String title) {
        return bookRepository.deleteBookByBookTitle(title);
    }
    @Override
    public int countBook(){return bookRepository.countBook();}

    @Override
    public List<Book> searchBooksByBookTitle(String bookTitle) {
        return bookRepository.searchBooksByBookTitle(bookTitle);
    }

    @Override
    public Integer countBookInCategory(String categoryId) {
        Integer count = bookRepository.countBookInCategory(categoryId);
        return count!=null ? count : 0;
    }

    @Override
    public Integer countAuthorBook(String authorId) {
        Integer count = bookRepository.countAuthorBook(authorId);
        return count!=null ? count : 0;
    }

    @Override
    public Integer countSupplierBook(String supplierId) {
        Integer count = bookRepository.countSupplierBook(supplierId);
        return count!=null ? count : 0;
    }

    @Override
    public Integer countPublisherBook(String publisherId) {
        Integer count = bookRepository.countPublisherBook(publisherId);
        return count!=null ? count : 0;
    }
    @Override
    public Book findBookByBookId(String bookId){
        return bookRepository.findBookByBookId(bookId);
    }

}