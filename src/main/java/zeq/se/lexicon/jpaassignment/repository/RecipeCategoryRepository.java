package zeq.se.lexicon.jpaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import zeq.se.lexicon.jpaassignment.entity.Recipe;
import zeq.se.lexicon.jpaassignment.entity.RecipeCategory;

import java.util.Collection;
import java.util.List;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {
    Collection<RecipeCategory> findByRecipesOrderByRecipes_CategoriesAsc(Recipe recipes);




}

