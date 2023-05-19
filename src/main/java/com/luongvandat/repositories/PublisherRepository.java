package com.luongvandat.repositories;

import com.luongvandat.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
//@CrossOrigin(origins = "http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins = "*")
public interface PublisherRepository extends JpaRepository<Publisher, String> {
    Publisher findByPublisherName(String name);
    List<Publisher> findPublishersBy();
    @Query(value = "SELECT * FROM publisher ORDER BY publisher_id ASC OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY ", nativeQuery = true)
    List<Publisher> find10Publishers(int offset);
    @Query(value = "SELECT * FROM publisher where publisher_name like '%'+?1+'%' ORDER BY publisher_id ASC OFFSET ?2 ROWS FETCH NEXT 10 ROWS ONLY ",nativeQuery = true)
    List<Publisher> search10PublisherByName(String publisherName,int offset);

    int countPublishersBy();
    Publisher findPublisherByPublisherNameIgnoreCase(String publisherName);
}