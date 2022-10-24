package zeq.se.lexicon.jpaassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import zeq.se.lexicon.jpaassignment.entity.*;
import zeq.se.lexicon.jpaassignment.repository.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.*;

@SpringBootApplication
public class JpaAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaAssignmentApplication.class, args);
    }

    public JpaAssignmentApplication() {
    }

    @Profile("dev")
    @Transactional
    @Component
    public class MyCommandLineRunner implements CommandLineRunner {

        private final IngredientRepository ingredientRepository;
        private final RecipeIngredientRepository recipeIngredientRepository;
        private final RecipeInstructionRepository recipeInstructionRepository;
        private final RecipeRepository recipeRepository;

        private final EntityManager entityManager;


        @Autowired
        public MyCommandLineRunner(IngredientRepository ingredientRepository, RecipeIngredientRepository recipeIngredientRepository, RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository, EntityManager entityManager) {
            this.ingredientRepository = ingredientRepository;
            this.recipeIngredientRepository = recipeIngredientRepository;
            this.recipeInstructionRepository = recipeInstructionRepository;
            this.recipeRepository = recipeRepository;
            this.entityManager = entityManager;

        }

        @Override
        public void run(String... args) throws Exception {

            ingredientRepository.deleteAll();

            recipeRepository.deleteAll();

            recipeInstructionRepository.deleteAll();


            /** Add Recipe's **/


            Recipe pancake = recipeRepository.save(new Recipe("Pancakes"));


            /** Save ingredients **/

            Ingredient Milk = ingredientRepository.save(new Ingredient("milk"));
            Ingredient Flour = ingredientRepository.save(new Ingredient("flour"));
            Ingredient Eggs = ingredientRepository.save(new Ingredient("eggs"));
            Ingredient Salt = ingredientRepository.save(new Ingredient("salt"));


            /** RecipeIngredients And amounts **/

            RecipeIngredient flour = new RecipeIngredient(Flour, 3, Measurement.DL);
            RecipeIngredient milk = new RecipeIngredient(Milk, 6, Measurement.DL);
            RecipeIngredient eggs = new RecipeIngredient(Salt, 3, Measurement.PCS);
            RecipeIngredient salt = new RecipeIngredient(Salt, 0.5, Measurement.TBSP);

            pancake.addRecipeIngredient(flour);
            pancake.addRecipeIngredient(milk);
            pancake.addRecipeIngredient(salt);
            pancake.addRecipeIngredient(eggs);
            entityManager.flush();


            flour.setIngredient(Flour);
            milk.setIngredient(Milk);
            eggs.setIngredient(Eggs);
            salt.setIngredient(Salt);
            entityManager.flush();

            recipeRepository.findRecipesByRecipeIngredientsIngredientIngredientName("egg").forEach(System.out::println);


            /** Find all ingredients &  Find all Recipes **/


            ingredientRepository.findAll().forEach(System.out::println);
            recipeRepository.findAll().forEach(System.out::println);


            /** Delete ingredient by name **/

            ingredientRepository.deleteByIngredientName("butter");


            /** Update ingredient**/
            //    ingredientRepository.updateIngredientNameByIngredientNameAllIgnoreCase("eggs", "egs");


            /** find by ingredient ignore Case **/

            List<Ingredient> ignoreCase = ingredientRepository.findByIngredientNameContainingIgnoreCase("eg");
            System.out.println(ignoreCase);

            /** Find ingredient by ID **/
            Optional<Ingredient> id1 = ingredientRepository.findById(1);
            System.out.println(id1);

            /** Find ingredient by Name **/
            List<Ingredient> name1 = ingredientRepository.findByIngredientNameIgnoreCase("milk");
            System.out.println(name1);

            /** Find all ingredients & Find all Category's **/

            ingredientRepository.findAll().forEach(System.out::println);

            /** Find all instructions **/

            recipeInstructionRepository.findAll().forEach(System.out::println);


            recipeRepository.findRecipesByRecipeIngredientsIngredientIngredientName("milk").forEach(System.out::println);
            recipeRepository.findAllByCategoriesCategoryIgnoreCase("vegan").forEach(System.out::println);
            recipeRepository.findAllByRecipeNameContainingIgnoreCase("").forEach(System.out::println);

        }
    }
}








