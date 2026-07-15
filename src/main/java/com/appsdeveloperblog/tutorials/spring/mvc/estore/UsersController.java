package com.appsdeveloperblog.tutorials.spring.mvc.estore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    @GetMapping(path="/users/{userId}")
    public ModelAndView getUser(@PathVariable("userId") String userId) {
        ModelAndView modelAndView = new ModelAndView("user");
        return modelAndView;
    }
}
//nurlan