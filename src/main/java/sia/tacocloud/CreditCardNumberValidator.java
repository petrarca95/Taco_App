package sia.tacocloud;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CreditCardNumberValidator implements ConstraintValidator<CreditCardConstraint, Order> {
    private static final String MASTERCARD_CARD_REGEX ="^5[1-5][0-9]{14}$|^2(?:2(?:2[1-9]|[3-9][0-9])|[3-6][0-9][0-9]|7(?:[01][0-9]|20))[0-9]{12}$";
    private static final String VISA_CARD_REGEX = "^4[0-9]{12}(?:[0-9]{3})?$";
    private static final String AE_CARD_REGEX ="^3[47][0-9]{13}$";



    private static final Pattern MC_CARD_PATTERN =
            Pattern.compile(MASTERCARD_CARD_REGEX);
    private static final Pattern VC_CARD_PATTERN =
            Pattern.compile(VISA_CARD_REGEX);
    private static final Pattern AE_CARD_PATTERN =
            Pattern.compile(AE_CARD_REGEX);


    @Override
    public boolean isValid(Order order, ConstraintValidatorContext constraintValidatorContext) {
        //TODO, test case with visa for Credit Card Company and 4111111111111111  for credit card number returning false

        Boolean h = order.getCcCompany().equalsIgnoreCase("visa") ;
        Boolean d = VC_CARD_PATTERN.matcher(order.getCcNumber()).matches();
        Boolean h2 = order.getCcCompany().equalsIgnoreCase("mastercard") ;
        Boolean d2 = MC_CARD_PATTERN.matcher(order.getCcNumber()).matches();
        Boolean h3 = order.getCcCompany().equalsIgnoreCase("american express") ;
        Boolean h4 = AE_CARD_PATTERN.matcher(order.getCcNumber()).matches();


        if(VC_CARD_PATTERN.matcher(order.getCcNumber()).matches() && order.getCcCompany().equalsIgnoreCase("visa") ||
                (MC_CARD_PATTERN.matcher(order.getCcNumber()).matches()  && order.getCcCompany().equalsIgnoreCase("mastercard")) ||
                (AE_CARD_PATTERN.matcher(order.getCcNumber()).matches()) && order.getCcCompany().equalsIgnoreCase("american express")) {
            System.out.println("true");
            return true;
        }
        else{
            return false;
        }

//        ||
//        (VC_CARD_PATTERN.matcher(order.getCcNumber()).matches()  && order.getCcCompany().equalsIgnoreCase("visa") )  ||
//                (AE_CARD_PATTERN.matcher(order.getCcNumber()).matches()) && order.getCcCompany().equalsIgnoreCase("american express")
//
//        if (order.getCcExpiration().equals(order.getCcCVV())){
//            return true;
//        }



    }
}
