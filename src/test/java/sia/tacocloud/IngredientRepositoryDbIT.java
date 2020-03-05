package sia.tacocloud;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class IngredientRepositoryDbIT {

    //Injecting real instance of the class containing real dependencies, since we are not testing the findById(..) method. I want to test the actual interaction with the DB
    @Autowired
    private IngredientRepositoryImpl ingredientRepository;

    @Test
    public void findByIdIT(){

        //Checking We are Retrieving one ingredient successfully
        Ingredient ingredient = ingredientRepository.findById("FLTO");
        Assertions.assertEquals("FLTO", ingredient.getId());
        Assertions.assertEquals("Flour Tortilla", ingredient.getName());
        Assertions.assertEquals("WRAP", ingredient.getType().toString());
    }

}
