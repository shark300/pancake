package io.github.pancake.app.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    public static final String REQUEST_MAPPING = "/";

    @RequestMapping(REQUEST_MAPPING)
    public String homepage() {
        return "homepage";
    }
}
