package com.example.recetas_cocina_api.service;

import com.example.recetas_cocina_api.models.RecipesEntity;
import com.example.recetas_cocina_api.repository.RecipesRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipesService {

    @Autowired
    private final RecipesRepository recipesRepository;

    public ResponseEntity<List<RecipesEntity>> getAll() {
        try {
            return new ResponseEntity<List<RecipesEntity>>(this.recipesRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<RecipesEntity>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<RecipesEntity>> getManyContainsTitle(@RequestParam String title) {
        try {
            return new ResponseEntity<List<RecipesEntity>>(this.recipesRepository.findAllByTitleContainsIgnoreCase(title), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<RecipesEntity>>(Collections.emptyList(), HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> createOne(@RequestBody RecipesEntity body) {
        RecipesEntity recipe = new RecipesEntity();
        try {
            recipe.setTitle(body.getTitle());
            recipe.setIngredients(body.getIngredients());
            recipe.setPreparationTime(body.getPreparationTime());
            recipe.setDifficultyLevel(body.getDifficultyLevel());
            recipe.setImageUrl(body.getImageUrl());
            recipe.setVideoUrl(body.getVideoUrl());
            this.recipesRepository.save(recipe);
            return new ResponseEntity<>("SUCCESS: Document: " + recipe + " has been created", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("ERROR: Document can't be created", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> updateOne(@RequestParam ObjectId id, @RequestBody RecipesEntity body) {
        Optional<RecipesEntity> optRecipe = this.recipesRepository.findById(id);
        RecipesEntity recipe;
        try {
            if (optRecipe.isPresent()) {
                recipe = optRecipe.get();
                recipe.setTitle(body.getTitle());
                recipe.setIngredients(body.getIngredients());
                recipe.setPreparationTime(body.getPreparationTime());
                recipe.setDifficultyLevel(body.getDifficultyLevel());
                recipe.setImageUrl(body.getImageUrl());
                recipe.setVideoUrl(body.getVideoUrl());
                this.recipesRepository.save(recipe);
                return new ResponseEntity<>("SUCCESS: Document: " + recipe + " has been updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("ERROR: Document with id: " + id + " not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>("ERROR: Document can't be updated", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteOneById(@PathVariable ObjectId id) {
        Optional<RecipesEntity> optRecipe = this.recipesRepository.findById(id);
        RecipesEntity recipe;
        try {
            if (optRecipe.isPresent()) {
                recipe = optRecipe.get();
                this.recipesRepository.delete(recipe);
                return new ResponseEntity<String>("SUCCESS: Document with " + id + " has been deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("ERROR: Document with id: " + id + " not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<String>("ERROR: Document with id: " + id + " can't be deleted", HttpStatus.NOT_FOUND);
        }
    }
}
