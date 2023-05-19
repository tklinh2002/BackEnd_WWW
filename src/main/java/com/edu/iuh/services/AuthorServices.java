package com.edu.iuh.services;

import com.edu.iuh.entities.Author;

import java.util.List;

public interface AuthorServices {
    Author findOneById(String id);

    Author add(Author author);

    Author deleteById(String id);

    Author update(Author author);

    Author findByAuthorName(String name);
    List<Author> findAuthorsBy();
    List<Author> find10Authors(int offset);

    List<Author> search10AuthorByName(String authorName, int offset);

    int countAuthorsBy();
    Author findAuthorByAuthorNameIgnoreCase(String authorName);
}