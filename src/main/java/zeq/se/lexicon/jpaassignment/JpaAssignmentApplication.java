package zeq.se.lexicon.jpaassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import zeq.se.lexicon.jpaassignment.entity.Ingredient;
import zeq.se.lexicon.jpaassignment.entity.RecipeCategory;
import zeq.se.lexicon.jpaassignment.entity.RecipeIngredient;
import zeq.se.lexicon.jpaassignment.repository.*;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        @Autowired
        public MyCommandLineRunner(IngredientRepository ingredientRepository, RecipeCategoryRepository recipeCategoryRepository, RecipeIngredientRepository recipeIngredientRepository, RecipeInstructionRepository recipeInstructionRepository, RecipeRepository recipeRepository) {
            this.ingredientRepository = ingredientRepository;
            this.recipeCategoryRepository = recipeCategoryRepository;
            this.recipeIngredientRepository = recipeIngredientRepository;
            this.recipeInstructionRepository = recipeInstructionRepository;
            this.recipeRepository = recipeRepository;
        }

        private final IngredientRepository ingredientRepository;
        private final RecipeCategoryRepository recipeCategoryRepository;
        private final RecipeIngredientRepository recipeIngredientRepository;
        private final RecipeInstructionRepository recipeInstructionRepository;
        private final RecipeRepository recipeRepository;

        @Override
        public void run(String... args) throws Exception {


           //Delete ingredient by name
            ingredientRepository.deleteByIngredientName("vatten");
            ingredientRepository.deleteByIngredientName("flour");

            // Update by name!
            ingredientRepository.updateIngredientNameByIngredientNameAllIgnoreCase("eggs","ggg");

            Ingredient pancake = new Ingredient("vatten");


        }
    }
}








