package zeq.se.lexicon.jpaassignment.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import zeq.se.lexicon.jpaassignment.entity.Ingredient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class IngredientRepositoryTest {

    public List<Ingredient> ingredients() {
        return Arrays.asList(
                new Ingredient("Milk"),
                new Ingredient("Flour"),
                new Ingredient("Eggs")
        );
    }


    @Autowired
    TestEntityManager entityManager;
    @Autowired
    IngredientRepository ingredientTestRepo;

    Ingredient testIngredients;

    @BeforeEach
    void setUp() {
        List<Ingredient> persistedIngredient = ingredients().stream()
                .map(entityManager::persist)
                .collect(Collectors.toList());
        testIngredients = persistedIngredient.get(0);
    }

    @Test
    void findByIngredientNameIgnoreCase() {
        String name = "Flour";
        List<Ingredient> found = ingredientTestRepo.findByIngredientNameIgnoreCase(name);
        assertEquals(1, found.size());
    }

}
