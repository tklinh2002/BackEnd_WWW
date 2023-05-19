package com.luongvandat.repositories;

import com.luongvandat.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Repository
//@CrossOrigin(origins = "http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
@CrossOrigin(origins = "*")
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findCategoryByCategoryName(String name);
    List<Category> findCategoriesBy();
    @Query(value = "SELECT * FROM category ORDER BY category_id ASC OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
    List<Category> find10Categories(int offset);

    @Query(value = "SELECT * FROM category where [category_name] like '%'+?1+'%' ORDER BY category_id ASC OFFSET ?2 ROWS FETCH NEXT 10 ROWS ONLY", nativeQuery = true)
    List<Category> searchCategoriesByCategoryName(String categoryName, int offset);

    int countCategoriesBy();

    Category findCategoryByCategoryNameIgnoreCase(String name);
}