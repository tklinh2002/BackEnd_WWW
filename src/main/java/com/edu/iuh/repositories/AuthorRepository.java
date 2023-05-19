package com.edu.iuh.repositories;

import com.edu.iuh.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
//@CrossOrigin(origins = "http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public interface AuthorRepository extends JpaRepository<Author, String> {
    Author findByAuthorName(String name);
    List<Author> findAuthorsBy();

    @Query(value = "SELECT * FROM author ORDER BY author_id ASC OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
    List<Author> find10Authors(int offset);
    @Query(value = "SELECT * FROM author where author_name like '%'+?1+'%' ORDER BY author_id ASC OFFSET ?2 ROWS FETCH NEXT 10 ROWS ONLY ",nativeQuery = true)
    List<Author> search10AuthorByName(String authorName,int offset);

    int countAuthorsBy();
    Author findAuthorByAuthorNameIgnoreCase(String authorName);
}