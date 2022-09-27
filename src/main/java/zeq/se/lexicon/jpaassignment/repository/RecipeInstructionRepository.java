package zeq.se.lexicon.jpaassignment.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import zeq.se.lexicon.jpaassignment.entity.RecipeInstruction;

import java.util.List;
import java.util.Optional;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, Integer> {
    List<RecipeInstruction> findByInstructionIgnoreCase(String instruction);


    @Override
    Optional<RecipeInstruction> findById(Integer integer);

    @Override
    Iterable<RecipeInstruction> findAll();

    List<RecipeInstruction> findByInstruction(String instruction, Pageable pageable);
}