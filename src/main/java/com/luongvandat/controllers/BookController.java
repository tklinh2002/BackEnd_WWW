package com.luongvandat.controllers;

import com.luongvandat.entities.*;
import com.luongvandat.services.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookServices bookServices;
    private final CategoryServices categoryServices;
    private final PublisherServices publisherServices;
    private final AuthorServices authorServices;
    private final SupplierServices supplierServices;

//    public BookController(BookServices bookServices) {
//        this.bookServices = bookServices;
//    }

    @PostMapping("/findByName")
    public List<Book> findByName(String name) {
        return bookServices.findBooksByBookTitleContainsIgnoreCase(name);
    }

    @PostMapping("/addBook")
    public ResponseEntity<String> addProduct(@RequestBody Book b){
        Book book = new Book();
        book.setBookTitle(b.getBookTitle());
        if(bookServices.findBookByBookTitleIgnoreCase(b.getBookTitle())!=null)
            return ResponseEntity.ok("Book is exist !!");
        book.setBookDescription(b.getBookDescription());
        book.setBookPrice(b.getBookPrice());
        book.setBookDiscount(b.getBookDiscount());
        book.setBookSize(b.getBookSize());
        book.setBookWeight(b.getBookWeight());
        book.setBookInventory(b.getBookInventory());
        book.setBookStatus(b.getBookStatus());
        book.setBookImage(b.getBookImage());
        System.out.println(b.getCategory().getCategoryName());
        Category category = categoryServices.findCategoryByCategoryName(b.getCategory().getCategoryName());
        book.setBookType(category.getCategoryName());
        book.setBookLanguage(b.getBookLanguage());
        book.setCategory(category);
        Author author = authorServices.findByAuthorName(b.getAuthor().getAuthorName());
        book.setAuthor(author);
        Publisher publisher = publisherServices.findByPublisherName(b.getPublisher().getPublisherName());
        book.setPublisher(publisher);
        Supplier supplier = supplierServices.findBySupplierName(b.getSupplier().getSupplierName());
        book.setSupplier(supplier);
        book.setBookSlug(b.getBookSlug());
        book.setBookCreatedDate(new Date());
        book.setBookUpdatedDate(new Date());
        bookServices.add(book);
        return ResponseEntity.ok("add product successful");
    }
    @GetMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam String bookTitle){
        Book book = bookServices.findBookByBookTitleIgnoreCase(bookTitle);
        bookServices.deleteById(book.getBookId());
        return ResponseEntity.ok("delete book "+bookTitle+" successful");
    }
    @PutMapping("/updateBook")
    public ResponseEntity<String> updateBook(@RequestBody Book b){
        Book book = bookServices.findBookByBookTitleIgnoreCase(b.getBookTitle());
        book.setBookDescription(b.getBookDescription());
        book.setBookPrice(b.getBookPrice());
        book.setBookDiscount(b.getBookDiscount());
        book.setBookSize(b.getBookSize());
        book.setBookWeight(b.getBookWeight());
        book.setBookInventory(b.getBookInventory());
        book.setBookStatus(b.getBookStatus());
        if(!b.getBookImage().equals("../imgs/static/")){
            book.setBookImage(b.getBookImage());
        }
        Category category = categoryServices.findCategoryByCategoryName(b.getCategory().getCategoryName());
        book.setCategory(category);
        book.setBookType(category.getCategoryName());
        Author author = authorServices.findByAuthorName(b.getAuthor().getAuthorName());
        book.setAuthor(author);
        Publisher publisher = publisherServices.findByPublisherName(b.getPublisher().getPublisherName());
        book.setPublisher(publisher);
        Supplier supplier = supplierServices.findBySupplierName(b.getSupplier().getSupplierName());
        book.setSupplier(supplier);
        bookServices.update(book);
        return ResponseEntity.ok("update product successful");
    }
}