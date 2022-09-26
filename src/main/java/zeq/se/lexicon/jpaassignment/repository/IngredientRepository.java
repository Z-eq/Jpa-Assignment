package zeq.se.lexicon.jpaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zeq.se.lexicon.jpaassignment.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}