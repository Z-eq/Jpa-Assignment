package zeq.se.lexicon.jpaassignment.entity;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "Recipe")
public class Recipe {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String recipeName;
    
    @OneToMany
    private List<RecipeIngredient> recipeIngredients;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_instruction")
    private RecipeInstruction recipeInstruction;

    /** NOt sure if this is right yet!!!!!*//////////////////////////////

    @ManyToMany
    @JoinTable(name = "recipe_categories"
            , joinColumns = @JoinColumn(name = "recipe_id")
            , inverseJoinColumns = @JoinColumn(name = "categories_id" ))

    private Set<RecipeCategory> categories;

                        /******* Not sure about above*/
    public Recipe() {
    }

    public Recipe(int id, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.categories = categories;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return Objects.equals(getRecipeName(), recipe.getRecipeName()) && Objects.equals(getRecipeIngredients(), recipe.getRecipeIngredients()) && Objects.equals(getRecipeInstruction(), recipe.getRecipeInstruction()) && Objects.equals(getCategories(), recipe.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeName(), getRecipeIngredients(), getRecipeInstruction(), getCategories());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", categories=" + categories +
                '}';
    }
}
