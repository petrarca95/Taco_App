package sia.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//* in book they added a @RequiredArgsConstructor annotation. Not needed because it is included in @Data
public class Ingredient {


    private final String id;
    private final String name;
    private final Type type;


    /**
     *! @Data adds getters and setters for all variables
     *! @Data also adds Constructor which has parameters for each final variable, which the compiler forces you to initialize either at declaration, in an initialization block, or at construction.
     *! The equivalent constructor can be seen below

     ** public Ingredient(String id, String name, Type type){
     ** this.id = id;
     **  this.name = name;
     ** this.type =type;
     **  }
     */


    public static enum Type{
        WRAP,PROTEIN,VEGGIES, CHEESE,SAUCE
    }

}
