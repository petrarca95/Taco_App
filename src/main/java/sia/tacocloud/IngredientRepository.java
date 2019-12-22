package sia.tacocloud;

import java.util.List;

public interface IngredientRepository {


    public Ingredient findById(String id);

    public List<Ingredient> findAll();

    public Ingredient save();

}
