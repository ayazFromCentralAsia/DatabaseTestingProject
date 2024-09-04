package com.example.ProjectForTesting.Repository;

import com.example.ProjectForTesting.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
