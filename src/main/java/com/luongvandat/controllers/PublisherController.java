package com.luongvandat.controllers;

import com.luongvandat.entities.Publisher;
import com.luongvandat.services.PublisherServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/publishers")
public class PublisherController {
    private PublisherServices publisherServices;

    public PublisherController(PublisherServices publisherServices) {
        this.publisherServices = publisherServices;
    }
    @PostMapping("/addPublisher")
    ResponseEntity<String> addPublisher(@RequestBody Publisher a){
        if(publisherServices.findPublisherByPublisherNameIgnoreCase(a.getPublisherName())!=null){
            return ResponseEntity.ok("Publisher exist!!!");
        }
        publisherServices.add(a);
        return ResponseEntity.ok("add Publisher successful");
    }
    @PutMapping("/updatePublisher")
    ResponseEntity<String> updatePublisher(@RequestBody Publisher a){
        Publisher publisher = publisherServices.findOneById(a.getPublisherId());
        publisher.setPublisherName(a.getPublisherName());
        publisherServices.update(publisher);
        return ResponseEntity.ok("update Category successful");
    }
    @GetMapping("/deletePublisher")
    ResponseEntity<String> deletePublisher(@RequestParam String publisherName){
        Publisher publisher = publisherServices.findPublisherByPublisherNameIgnoreCase(publisherName);
        publisherServices.deleteById(publisher.getPublisherId());
        return ResponseEntity.ok("delete Category successful");
    }

}
