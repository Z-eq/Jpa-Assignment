package zeq.se.lexicon.jpaassignment.entity;


import zeq.se.lexicon.jpaassignment.repository.IngredientRepository;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Recipe")

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Integer id;
    @Column(name = "recipe_name", unique = true)
    private String recipeName;

    @OneToMany(mappedBy = "recipe", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})

    private List<RecipeIngredient> recipeIngredients;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_instruction")
    private RecipeInstruction recipeInstruction;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "recipe_recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_category_id"))
    private Set<RecipeCategory> categories;

    public Recipe() {
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
    }

    public Recipe(String recipeName, RecipeInstruction recipeInstruction) {
        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
    }

    public Recipe(String recipeName, RecipeInstruction recipeInstruction, Set<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeInstruction = recipeInstruction;
        this.categories = categories;
    }

    public Recipe(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, Set<RecipeCategory> categories) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.categories = categories;
    }

    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) throw new IllegalArgumentException("Recipe Ingredient is null");
        if (recipeIngredients == null) recipeIngredients = new ArrayList<>();
        recipeIngredients.add(recipeIngredient);
        recipeIngredient.setRecipe(this);
    }

    public void removeRecipeIngredient(RecipeIngredient recipeIngredient) {
        if (recipeIngredient == null) throw new IllegalArgumentException("Recipe Ingredient is null");
        if (!recipeIngredients.contains(recipeIngredient)) throw new IllegalArgumentException("not found");
        recipeIngredients.remove(recipeIngredient);
        recipeIngredient.setRecipe(null);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void addCategory(RecipeCategory recipeCategory) {

        if (recipeCategory == null) throw new IllegalArgumentException("null");
        if (categories == null)
            categories = new HashSet<>();
        if (!categories.contains(recipeCategory)) {
            categories.add(recipeCategory);
        }
    }

    public void removeCategory(RecipeCategory recipeCategory) {
        if (categories.contains(recipeCategory)) {
            categories.remove(recipeCategory);
        }
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(getId(), recipe.getId()) && Objects.equals(getRecipeName(), recipe.getRecipeName());
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
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", categories=" + categories +
                '}';
    }
}


