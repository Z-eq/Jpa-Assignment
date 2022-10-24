package zeq.se.lexicon.jpaassignment.entity;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH,} ,fetch = FetchType.EAGER)
   @JoinColumn( name = "ingredient_id")
    private Ingredient ingredient;

     @Column(name=  "amount")
    private double amount;

    @Enumerated(EnumType.STRING)
    private Measurement measurement;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public RecipeIngredient() {
    }

    public RecipeIngredient(double amount, Measurement measurement) {
        this.amount = amount;
        this.measurement = measurement;
    }

    public RecipeIngredient(Ingredient ingredient, Measurement measurement) {
        this.ingredient = ingredient;
        this.measurement = measurement;
    }

    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
    }

    public RecipeIngredient(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public RecipeIngredient(Integer id, Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.id = id;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 && Objects.equals(getIngredient(), that.getIngredient()) && getMeasurement() == that.getMeasurement() && Objects.equals(getRecipe(), that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIngredient(), getAmount(), getMeasurement(), getRecipe());
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", amount=" + amount +
                ", measurement=" + measurement +
                '}';
    }
}
