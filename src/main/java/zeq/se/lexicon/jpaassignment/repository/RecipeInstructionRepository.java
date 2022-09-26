package zeq.se.lexicon.jpaassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zeq.se.lexicon.jpaassignment.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends JpaRepository<RecipeInstruction, Integer> {
}