package com.example.recetas_cocina_api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.sql.Time;
import java.util.List;

@Document(collection = "recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipesEntity {
    @Id
    private ObjectId id;
    private String title;
    private List<String> ingredients;
    private String preparationTime;
    private String difficultyLevel;
    private String imageUrl;
    private String videoUrl;
}
