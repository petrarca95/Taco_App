package sia.tacocloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller

/*
 ! when applied to the class, it designates the method handlers of this class
 ! as methods that will handle any request to "/design", we can further refine which handlers handle what request
 ! by adding more annotations to each method
 */

@RequestMapping("/design")
public class DesignTacoController {

    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET)
    public String showDesignForm(Model model) {

        List<Ingredient> ingredients = Arrays.asList(
//                (new Ingredient("BEFF", "beef", Ingredient.Type.PROTEIN)),
//                (new Ingredient("CHICKEN", "chicken", Ingredient.Type.PROTEIN)),
//                (new Ingredient("CHED", "cheddar", Ingredient.Type.CHESSE)),
//                (new Ingredient("MOZ", "mozzarella", Ingredient.Type.CHESSE)),
//                (new Ingredient("LET", "letuce", Ingredient.Type.VEGGIES))
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );

        //* Get all types in a list
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            //* change the type to a string, add it to model as key value pair, where key is the name of the incredient type
            //* the value is a List containing all ingredients of a specific type
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        model.addAttribute("design",new Taco());



        //add the list of all ingredients


        return "design";
    }



    @RequestMapping(method = RequestMethod.POST)
    /**
     ** @ModelAttribute will bind parameters submitted via the form to instance variables in the Taco object (Used here as a Command object)
     ** Where do we get the Taco object? If there is currently one in the Spring Container, from there, if not one is instantiated, Form does not actually send it
     *! @RequestParam List<String> ingredients, @RequestParam String name in handler method can be used to bind data sent in URL of GET or in this case, body of POST request, to a Java object
     ** @RequestParam is used to illustrate it's used but we do not need it since we already POSTed data to Taco Model Object
      */

    //*!
    public String processDesign(@ModelAttribute Taco tacoDesign, @RequestParam List<String> ingredients, @RequestParam String name){
        //TODO Save the Taco Design
        log.info("Processing design: "+tacoDesign);


        return "orderForm";
    }









    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
