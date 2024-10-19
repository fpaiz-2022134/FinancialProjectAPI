package com.francopaiz.financialManagementAPI.repository.category;

import com.francopaiz.financialManagementAPI.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
