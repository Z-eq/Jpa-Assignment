package zeq.se.lexicon.jpaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import zeq.se.lexicon.jpaassignment.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query("select r from Recipe r where upper(r.recipeName) like upper(concat('%', ?1, '%'))")
    List<Recipe>findAllByRecipeNameContainingIgnoreCase(String recipeName);

    List<Recipe> findByRecipeNameOrderByRecipeIngredients_Ingredient_IngredientName(String recipeName);

    List<Recipe> findAllByCategoriesCategoryIgnoreCase(String category);


    List<Recipe> findRecipesByRecipeIngredientsIngredientIngredientName(String ingredientName);



    /** Find contain **/



}