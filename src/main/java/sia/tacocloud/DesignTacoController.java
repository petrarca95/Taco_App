package sia.tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class DesignTacoController {

    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    @RequestMapping(value = "/design", method = RequestMethod.GET )
    public String getDesignOptions(Model model){
        ingredients.add(new Ingredient("BEFF","beef", Ingredient.Type.PROTEIN));
        ingredients.add(new Ingredient("CHICKEN","chicken", Ingredient.Type.PROTEIN));
        ingredients.add(new Ingredient("CHED","cheddar", Ingredient.Type.CHESSE));
        ingredients.add(new Ingredient("MOZ","mozzarella", Ingredient.Type.CHESSE));
        ingredients.add(new Ingredient("LET","letuce", Ingredient.Type.VEGGIES));

        model.addAttribute("ingredients", ingredients);

        return "design";
    }
}
