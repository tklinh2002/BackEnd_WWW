package com.luongvandat.services.impl;

import com.luongvandat.entities.Author;
import com.luongvandat.repositories.AuthorRepository;
import com.luongvandat.services.AuthorServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServicesImpl implements AuthorServices {
    private final AuthorRepository authorRepository;

    public AuthorServicesImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findOneById(String id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author add(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author deleteById(String id) {
        Author author = findOneById(id);
        authorRepository.deleteById(id);
        return author;
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findByAuthorName(String name) {
        return authorRepository.findByAuthorName(name);
    }

    @Override
    public List<Author> findAuthorsBy() {
        return authorRepository.findAuthorsBy();
    }

    @Override
    public List<Author> find10Authors(int offset) {
        return authorRepository.find10Authors(offset);
    }

    @Override
    public List<Author> search10AuthorByName(String authorName, int offset) {
        return authorRepository.search10AuthorByName(authorName,offset);
    }

    @Override
    public int countAuthorsBy() {
        return authorRepository.countAuthorsBy();
    }

    @Override
    public Author findAuthorByAuthorNameIgnoreCase(String authorName) {
        return authorRepository.findAuthorByAuthorNameIgnoreCase(authorName);
    }
}