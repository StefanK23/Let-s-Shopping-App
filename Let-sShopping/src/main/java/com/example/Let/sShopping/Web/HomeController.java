package com.example.Let.sShopping.Web;

import com.example.Let.sShopping.CurrentUser;
import com.example.Let.sShopping.Services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ProductService productService) {
        this.currentUser = currentUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        if(currentUser.getId()==null){
            return "index";
        }
        model.addAttribute("totalSum", productService.getTotalPrice()==null? 0: productService.getTotalPrice());
        model.addAttribute("drinks", productService.findAllByCategory("Drink"));
        model.addAttribute("foods", productService.findAllByCategory("Food"));
        model.addAttribute("houseHolds", productService.findAllByCategory("Household"));
        model.addAttribute("others",productService.findAllByCategory("Other"));
        return "home";
    }
}
