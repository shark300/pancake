package io.github.pancake.app.home.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for the homepage.
 * @author Bence_Kornis
 */
@Controller
public class HomeController {
    private static final String HOMEPAGE = "homepage";
    private static final String REQUEST_MAPPING = "/";

    @RequestMapping(REQUEST_MAPPING)
    public String homepage() {
        return HOMEPAGE;
    }
}
