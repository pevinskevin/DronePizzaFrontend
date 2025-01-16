package com.pevinskevin.dronepizzafrontend.Controller;

import com.pevinskevin.dronepizzafrontend.Model.Delivery;
import com.pevinskevin.dronepizzafrontend.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    ApiService apiService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("delivery", new Delivery());
        model.addAttribute("listOfDeliveries", apiService.getDeliveries());
        return "index";
    }
}
