package zeq.se.lexicon.jpaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import zeq.se.lexicon.jpaassignment.entity.RecipeIngredient;

import java.util.List;
import java.util.Optional;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer> {
    Optional<RecipeIngredient> findByIngredient_IngredientName(String ingredientName);


    @Override
    Iterable<RecipeIngredient> findAll();

    @Override
    Iterable<RecipeIngredient> findAllById(Iterable<Integer> integers);
}