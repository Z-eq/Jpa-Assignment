package zeq.se.lexicon.jpaassignment.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity

//@Table(name = "Recipecategory")
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "recipe_category_id")
    private Integer id;
    //@Column(name = "category")
    private String category;
    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<Recipe> recipes = new HashSet<>();

    public RecipeCategory() {
    }

    public RecipeCategory(String category, Set<Recipe> recipes) {
        this.category = category;
        this.recipes = recipes;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    // toDO ******************************************

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    //toDO *******************************************
    public void addRecipe(Recipe recipe){

        if(recipe == null) throw new IllegalArgumentException("This recipe is null");

        /*********** Add ************************/
        if(recipes == null) recipes = new HashSet<>();

        if(!recipes.contains(recipe))
            recipe.getCategories().add(this);
            recipes.add(recipe);

    }

    /**** Remove ***/
    public void removeRecipe(Recipe recipe) {

        if (recipe == null) throw new IllegalArgumentException("Recipe already in exists in db");
        if (recipes == null) setRecipes(new HashSet<>());

        if(recipes.contains(recipe)) {
            recipe.getCategories().remove(this);
            recipes.remove(recipe);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return Objects.equals(getCategory(), that.getCategory()) && Objects.equals(getRecipes(), that.getRecipes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCategory(), getRecipes());
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}

