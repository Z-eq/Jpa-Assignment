package zeq.se.lexicon.jpaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zeq.se.lexicon.jpaassignment.entity.RecipeCategory;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Integer> {
}