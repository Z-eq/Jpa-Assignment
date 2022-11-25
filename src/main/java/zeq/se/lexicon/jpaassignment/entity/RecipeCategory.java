package zeq.se.lexicon.jpaassignment.entity;

import javax.persistence.*;
import java.util.*;

@Entity

public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    //@Column(name = "category")
    private String category;
    @ManyToMany(mappedBy = "categories", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
   Set<Recipe> recipes = new HashSet<>();

    public RecipeCategory() {
    }


    public RecipeCategory(String category) {
        this.category = category;
    }

    public RecipeCategory(Integer id, String category, Set<Recipe> recipes) {
        this.id = id;
        this.category = category;
        this.recipes = recipes;
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

    public RecipeCategory setCategory(String category) {
        this.category = category;
        return null;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }


    /*******************************************/

        public void addRecipe(Recipe recipe) {
            if (!recipes.contains(recipe)) {
                recipes.add(recipe);

            }
        }
    /**** Remove ***/
         public void removeRecipe(Recipe recipe) {
             if (recipes.contains(recipe)) {
                 recipes.remove(recipe);
             }
         }
                /****/
    private void recipes(HashSet<Object> objects) {
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

