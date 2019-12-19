package sia.tacocloud;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CreditCardNumberValidator.class)
@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CreditCardConstraint {
    String message() default "Make sure credit card number is valid for credit card company";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
