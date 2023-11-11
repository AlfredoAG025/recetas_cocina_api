package com.example.recetas_cocina_api.controller;

import com.example.recetas_cocina_api.models.RecipesEntity;
import com.example.recetas_cocina_api.service.RecipesService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/recipes")
@CrossOrigin
@RestController
@AllArgsConstructor
public class RecipesController {
    @Autowired
    private final RecipesService recipesService;

    @GetMapping
    public ResponseEntity<List<RecipesEntity>> getAll() {
        return this.recipesService.getAll();
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecipesEntity>> getOneContainsTitle(@RequestParam String title) {
        return this.recipesService.getManyContainsTitle(title);
    }

    @PostMapping
    public ResponseEntity<String> createOne(@RequestBody RecipesEntity body){
        return this.recipesService.createOne(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOne(@PathVariable ObjectId id, @RequestBody RecipesEntity body){
        return this.recipesService.updateOne(id, body);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchOne(@PathVariable ObjectId id, @RequestBody RecipesEntity body){
        return this.recipesService.updateOne(id, body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable ObjectId id) {
        return this.recipesService.deleteOneById(id);
    }


}
