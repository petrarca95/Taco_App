package sia.tacocloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

//@Repository
public class IngredientRepositoryImpl implements IngredientRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Ingredient findById(String id) {
        return null;
    }

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient save() {
        return null;
    }
}
