package com.luongvandat.services;

import com.luongvandat.entities.Publisher;

import java.util.List;

public interface PublisherServices {
    Publisher findOneById(String id);

    Publisher add(Publisher publisher);

    Publisher deleteById(String id);

    Publisher update(Publisher publisher);

    Publisher findByPublisherName(String name);
    List<Publisher> findPublishersBy();

    List<Publisher> find10Publishers(int offset);
    List<Publisher> search10PublisherByName(String publisherName, int offset);

    int countPublishersBy();
    Publisher findPublisherByPublisherNameIgnoreCase(String publisherName);
}