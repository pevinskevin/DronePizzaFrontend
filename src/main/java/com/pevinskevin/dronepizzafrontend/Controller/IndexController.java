package com.pevinskevin.dronepizzafrontend.Controller;

import com.pevinskevin.dronepizzafrontend.Model.Delivery;
import com.pevinskevin.dronepizzafrontend.Service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ApiService apiService;

    @GetMapping("/")
    public String index(Model model) throws Exception {
        List<Delivery> deliveries = apiService.getDeliveries();
        deliveries.sort(Comparator.comparing(Delivery::getExpectedDeliveryTime));
        model.addAttribute("deliveries", deliveries);
        return "index";
    }
}
