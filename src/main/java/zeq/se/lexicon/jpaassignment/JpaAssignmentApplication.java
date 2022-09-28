package zeq.se.lexicon.jpaassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import zeq.se.lexicon.jpaassignment.entity.Ingredient;
import zeq.se.lexicon.jpaassignment.entity.Recipe;
import zeq.se.lexicon.jpaassignment.repository.*;

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



            /** Add ingredients **/

            Ingredient milk = ingredientRepository.save(new Ingredient("milk"));
            Ingredient flour = ingredientRepository.save(new Ingredient("flour"));
            Ingredient eggs = ingredientRepository.save(new Ingredient("eggs"));
            Ingredient salt = ingredientRepository.save(new Ingredient("salt"));

            /** Add Recipes **/





                /** Delete ingredient by name **/

                ingredientRepository.deleteByIngredientName("butter");


                /** Update ingredient**/
                ingredientRepository.updateIngredientNameByIngredientNameAllIgnoreCase("gggg","eggs");


                /** find by ingredient gnonreCase **/

                List<Ingredient> ignorecase = ingredientRepository.findByIngredientNameContainingIgnoreCase("gg");
                System.out.println(ignorecase);

                /** Find ingredient by ID **/
                Optional<Ingredient> id1 = ingredientRepository.findById(1);
                System.out.println(id1);

                /** Find ingredient by Name **/
                List<Ingredient> name1 = ingredientRepository.findByIngredientNameIgnoreCase("milk");
                System.out.println(name1);

                /** Find all ingredients **/

               ingredientRepository.findAll().forEach(System.out::println);




        }

    }
}








