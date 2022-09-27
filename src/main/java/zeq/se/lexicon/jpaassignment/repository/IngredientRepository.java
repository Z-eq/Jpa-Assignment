package zeq.se.lexicon.jpaassignment.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import zeq.se.lexicon.jpaassignment.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

           //Update ingredient by name!
    @Transactional
    @Modifying
    @Query("update Ingredient i set i.ingredientName = ?1 where upper(i.ingredientName) = upper(?2)")
    int updateIngredientNameByIngredientNameAllIgnoreCase(String ingredientName, String ingredientName1);
  

    List<Ingredient> deleteByIngredientName(String ingredientName);
    @Query("select i from Ingredient i where upper(i.ingredientName) = upper(?1)")
    List<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);

    Optional<Ingredient> findByIngredientNameContainingIgnoreCase(String ingredientName);


    
    
}