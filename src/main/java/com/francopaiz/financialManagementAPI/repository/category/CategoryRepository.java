package com.francopaiz.financialManagementAPI.repository.category;

import com.francopaiz.financialManagementAPI.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
