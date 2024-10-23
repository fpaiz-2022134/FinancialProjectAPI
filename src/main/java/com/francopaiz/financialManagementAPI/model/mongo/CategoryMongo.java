package com.francopaiz.financialManagementAPI.model.mongo;

import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
@Data
@Document(collection = "category")
public class CategoryMongo {

    @Id
    private String id;
    private String name;

}

