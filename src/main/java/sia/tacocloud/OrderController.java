package sia.tacocloud;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/orders")
public class OrderController {

    @GetMapping(value = "/current")
    public String orderForm(Model model){


        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping()
    public String processOrder(@ModelAttribute @Valid Order order, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "orderForm";
        }


        log.info("Order submitted: " + order);

        //TODO add logic to persist order

        return "redirect:/";
    }



}
