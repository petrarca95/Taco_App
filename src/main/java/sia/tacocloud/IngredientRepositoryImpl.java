package sia.tacocloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Ingredient findById(String id) {

        return jdbcTemplate.queryForObject("select * from INGREDIENT where id =?",new Object[]{id},  (rs, rowNum) ->
                new Ingredient(
                        rs.getString("id"),
                        rs.getString("name"),
                        Ingredient.Type.valueOf(rs.getString("type"))
                ));
    }

    @Override
    public List<Ingredient> findAll() {

        return jdbcTemplate.query("select * from Ingredient", new IngredientRowMapper()  );
    }

    @Override
    public Ingredient save(Ingredient ingredient) {

       jdbcTemplate.update(
                "insert into Ingredient (id, name, type) values (?, ?, ?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }



    private static  final class IngredientRowMapper implements RowMapper<Ingredient>{
        @Override
        public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Ingredient(
                    rs.getString("id"),
                    rs.getString("name"),
                    Ingredient.Type.valueOf(rs.getString("type"))
            );
        }
    }

}



