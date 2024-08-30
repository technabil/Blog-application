package com.nabil.blogapp.reposatories;

import com.nabil.blogapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
