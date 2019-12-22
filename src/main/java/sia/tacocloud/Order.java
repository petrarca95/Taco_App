package sia.tacocloud;


import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

//* Cross field validation verifying card number matches possible number for each company
@CreditCardConstraint
@Data
public class Order {
    private Long id;
    private Date createdAt;
    @NotEmpty(message = "field cannot me empty" )
    private String name;
    @NotEmpty(message = "field cannot me empty" )
    private String street;
    @NotEmpty(message = "field cannot me empty" )
    private String city;
    @NotEmpty(message = "field cannot me empty" )
    private String state;
    @NotEmpty(message = "field cannot me empty" )
    private String zip;
    @CreditCardNumber(message = "not a valid credit card number", ignoreNonDigitCharacters = true)
    private String ccNumber;
    @NotEmpty(message = "field cannot me empty" )
    private String ccExpiration;
    @NotEmpty(message = "field cannot me empty" )
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
    @NotEmpty(message = "field cannot me empty" )
    private String ccCompany;
}
