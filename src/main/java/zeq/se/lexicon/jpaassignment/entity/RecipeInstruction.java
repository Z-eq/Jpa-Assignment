package zeq.se.lexicon.jpaassignment.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instruction_id")
    private Integer id;

    @Column(name = "instructions" ,length = 1500)

    private String instruction;

    public RecipeInstruction() {
    }

    public RecipeInstruction(Integer id, String instruction) {
        this.id = id;
        this.instruction = instruction;
    }

    public RecipeInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getInstruction(), that.getInstruction());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getInstruction());
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "id='" + id + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
