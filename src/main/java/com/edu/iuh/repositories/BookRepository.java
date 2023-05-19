package com.edu.iuh.repositories;

import com.edu.iuh.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
//@CrossOrigin(origins = "http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin(origins = "*")
public interface BookRepository extends JpaRepository<Book, String> {
//    List<Book> findBooksByBookTitleContainsIgnoreCase(String bookTitle);

    List<Book> findBooksByBookIdBetween(String low, String high);

    Book findBookByBookTitleIgnoreCase(String bookTitle);

    Page<Book> findBooksByBookTitleContainsIgnoreCase(String bookTitle, Pageable pageable);

    Page<Book> findBooksByBookTitleContainsIgnoreCaseAndAuthorAuthorIdContains(String bookTitle, String author, Pageable pageable);

    Page<Book> findByAuthorAuthorIdContains(String author, Pageable pageable);

    Page<Book> findByCategoryCategoryIdAndAuthorAuthorIdContains(String category, String author, Pageable pageable);

    @Query(value = "SELECT * FROM book ORDER BY book_id ASC OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
    List<Book> find10Books(int offset);
    @Query(value = "select count(*) from book", nativeQuery = true)
    int countBook();
    boolean deleteBookByBookTitle(String title);
    @Query(value = "SELECT * FROM book where book_title like '%'+?1+'%' ORDER BY book_id ASC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
    List<Book> searchBooksByBookTitle(String bookTitle);
    @Query(value = "select count(*) from [dbo].[book] where category_category_id = ?1", nativeQuery = true)
    Integer countBookInCategory(String categoryId);
    @Query(value = "select count(*) from [dbo].[book] where author_author_id = ?1", nativeQuery = true)
    Integer countAuthorBook(String authorId);
    @Query(value = "select count(*) from [dbo].[book] where supplier_supplier_id = ?1", nativeQuery = true)
    Integer countSupplierBook(String supplierId);
    @Query(value = "select count(*) from [dbo].[book] where publisher_publisher_id = ?1", nativeQuery = true)
    Integer countPublisherBook(String publisherId);

    Book findBookByBookId(String bookId);
}