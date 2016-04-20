package io.github.pancake.app.order.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.pancake.app.order.view.model.ListPancakesModel;
import io.github.pancake.persistence.base.Pancake;
import io.github.pancake.service.PancakeService;

@Controller
public class OrderController {
    public static final String REQUEST_MAPPING = "/order.html";
    private PancakeService pancakeService;

    @Autowired
    public OrderController(PancakeService pancakeService) {
        this.pancakeService = pancakeService;
    }

    @ModelAttribute("listPancakesModel")
    public ListPancakesModel createListBooksModel() {
        List<Pancake> pancakes = listPancakes();
        return initListPancakesModel(pancakes);
    }

    @RequestMapping(REQUEST_MAPPING)
    public String order() {
        return "order";
    }

    private List<Pancake> listPancakes() {
        return pancakeService.getAvailablePancakes();
    }

    private ListPancakesModel initListPancakesModel(List<Pancake> pancakes) {
        return new ListPancakesModel(pancakes);
    }
}
