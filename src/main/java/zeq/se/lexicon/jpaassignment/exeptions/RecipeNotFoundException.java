package zeq.se.lexicon.jpaassignment.exeptions;

public class RecipeNotFoundException extends  Exception {

    private Integer id;




    public RecipeNotFoundException(Integer id) {
        super(String.format("Recipe with id: " + id + ", does not exist, make sure you entered correct id"));
    }

}
