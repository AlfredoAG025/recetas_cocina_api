package com.example.recetas_cocina_api.repository;

import com.example.recetas_cocina_api.models.RecipesEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecipesRepository extends MongoRepository<RecipesEntity, ObjectId> {

    public List<RecipesEntity> findAllByTitleContainsIgnoreCase(String title);
}
