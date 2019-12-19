package sia.tacocloud;


import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//* Cross field validation verifying card number matches possible number for each company
@CreditCardConstraint
@Data
public class Order {
    @NotEmpty
    private String name;
    @NotEmpty
    private String street;
    private String city;
    @NotEmpty
    private String state;
    private String zip;
    @NotEmpty
//    @CreditCardNumber(message = "not a valid credit card number", ignoreNonDigitCharacters = true)
    private String ccNumber;
    @NotEmpty
    private String ccExpiration;
    @NotEmpty
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @NotEmpty
    private String ccCompany;
}
