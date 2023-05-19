package com.luongvandat.services.impl;

import com.luongvandat.entities.Publisher;
import com.luongvandat.repositories.PublisherRepository;
import com.luongvandat.services.PublisherServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServicesImpl implements PublisherServices {
    private final PublisherRepository publisherRepository;

    public PublisherServicesImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher findOneById(String id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public Publisher add(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher deleteById(String id) {
        Publisher publisher = findOneById(id);
        publisherRepository.deleteById(id);
        return publisher;
    }

    @Override
    public Publisher update(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher findByPublisherName(String name) {
        return publisherRepository.findByPublisherName(name);
    }

    @Override
    public List<Publisher> findPublishersBy() {
        return publisherRepository.findPublishersBy();
    }

    @Override
    public List<Publisher> find10Publishers(int offset) {
        return publisherRepository.find10Publishers(offset);
    }

    @Override
    public List<Publisher> search10PublisherByName(String publisherName, int offset) {
        return publisherRepository.search10PublisherByName(publisherName,offset);
    }

    @Override
    public int countPublishersBy() {
        return publisherRepository.countPublishersBy();
    }

    @Override
    public Publisher findPublisherByPublisherNameIgnoreCase(String publisherName) {
        return publisherRepository.findPublisherByPublisherNameIgnoreCase(publisherName);
    }
}