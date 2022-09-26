package zeq.se.lexicon.jpaassignment.entity;

import javax.persistence.*;
import java.util.*;


// mappedBy "recipe" problem måste kolla om !

@Entity
@Table(name = "Recipe")

public class Recipe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "recipe_id")
    private Integer id;
@Column(name = "recipe_name")
    private String recipeName;

    @OneToMany( mappedBy = "recipe" , cascade =  {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH})

    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)

   @JoinColumn(name = "recipe_instruction")
    private RecipeInstruction recipeInstruction;

    /** NOt sure if this is right yet!!!!!*//////////////////////////////

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private Set<RecipeCategory> categories = new HashSet<>();

    public Recipe() {
    }

    /******* Not sure about above*/


    public Recipe(Integer id) {
        this.id = id;
    }

    public Recipe(Integer id, String recipeName, RecipeInstruction recipeInstruction) {
        this.id = id;

        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;
    }

    public Recipe(Integer id, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return getId() == recipe.getId() && Objects.equals(getRecipeName(), recipe.getRecipeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRecipeName());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", recipeInstruction=" + recipeInstruction +
                '}';
    }
}
