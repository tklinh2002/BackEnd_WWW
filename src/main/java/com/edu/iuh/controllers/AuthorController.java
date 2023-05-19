package com.edu.iuh.controllers;

import com.edu.iuh.services.AuthorServices;
import com.edu.iuh.entities.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/authors")
public class AuthorController {
    private AuthorServices authorServices;

    public AuthorController(AuthorServices authorServices) {
        this.authorServices = authorServices;
    }
    @PostMapping("/addAuthor")
    ResponseEntity<String> addAuthor(@RequestBody Author a){
        if(authorServices.findAuthorByAuthorNameIgnoreCase(a.getAuthorName())!=null){
            return ResponseEntity.ok("Author exist!!!");
        }
        authorServices.add(a);
        return ResponseEntity.ok("add Author successful");
    }
    @PutMapping("/updateAuthor")
    ResponseEntity<String> updateAuthor(@RequestBody Author a){
        Author author = authorServices.findOneById(a.getAuthorId());
        author.setAuthorName(a.getAuthorName());
        authorServices.update(author);
        return ResponseEntity.ok("update Category successful");
    }
    @GetMapping("/deleteAuthor")
    ResponseEntity<String> deleteAuthor(@RequestParam String authorName){
        Author author = authorServices.findAuthorByAuthorNameIgnoreCase(authorName);
        authorServices.deleteById(author.getAuthorId());
        return ResponseEntity.ok("delete Category successful");
    }

}
