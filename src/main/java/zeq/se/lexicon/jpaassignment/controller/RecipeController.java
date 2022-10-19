package zeq.se.lexicon.jpaassignment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zeq.se.lexicon.jpaassignment.entity.Recipe;
import zeq.se.lexicon.jpaassignment.exeptions.RecipeNotFoundException;
import zeq.se.lexicon.jpaassignment.repository.RecipeRepository;

import java.util.List;

@CrossOrigin
@RestController
public class RecipeController {

    final
    RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    //Get all recipes
    @GetMapping("/recipe")
    public List<Recipe> getAllRecipes() {

        //model.addAttribute(new Recipe());
        return (List<Recipe>) recipeRepository.findAll();
    }

    //Create new recipe
    @PostMapping("/recipe")
    public Recipe createRecipe(@RequestBody Recipe recipe) {

        //model.addAttribute("recipe", new Recipe(ingredients, recipeTitle));
        return recipeRepository.save(recipe);
    }

    // Get a single recipe
    @GetMapping("/recipe/{id}")
    public Recipe getRecipeById(@PathVariable(value = "id") Integer id) throws RecipeNotFoundException {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }


    // Update a recipe



    // Delete a recipe
    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable(value = "id") Integer id) throws RecipeNotFoundException {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));

        recipeRepository.delete(recipe);

        return ResponseEntity.ok().build();
    }

}



