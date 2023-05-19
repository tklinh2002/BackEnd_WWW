package com.luongvandat.controllers;

import com.luongvandat.entities.Category;
import com.luongvandat.services.CategoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> categories = categoryServices.findAll();
        System.out.println(categories.get(1));
        if (categories.isEmpty()) {
            System.out.println("loi");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    ResponseEntity<String> addCategory(@RequestBody Category category){
        if(categoryServices.findCategoryByCategoryNameIgnoreCase(category.getCategoryName())!=null){
            return ResponseEntity.ok("Category exist!!!");
        }
        categoryServices.add(category);
        return ResponseEntity.ok("add Category successful");
    }
    @PutMapping("/updateCategory")
    ResponseEntity<String> updateCategory(@RequestBody Category category){
        Category c = categoryServices.findOneById(category.getCategoryId());
        c.setCategoryName(category.getCategoryName());
        categoryServices.update(c);
        return ResponseEntity.ok("update Category successful");
    }
    @GetMapping("/deleteCategory")
    ResponseEntity<String> deleteCategory(@RequestParam String categoryName){
        Category category = categoryServices.findCategoryByCategoryNameIgnoreCase(categoryName);
        categoryServices.deleteById(category.getCategoryId());
        return ResponseEntity.ok("delete Category successful");
    }
}
