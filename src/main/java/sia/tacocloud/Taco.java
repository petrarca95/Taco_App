package sia.tacocloud;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Taco {
    private Long id;
    private Date createdAt;
    //*I used not null because the name can be left empty
    @NotBlank
    private String name;
    @Size(min=1, message = "you must choose at least one ingredient")
    private List<String> ingredients = new ArrayList<>();

}
