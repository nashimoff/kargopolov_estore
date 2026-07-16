package com.appsdeveloperblog.tutorials.spring.mvc.estore;

import com.appsdeveloperblog.tutorials.spring.mvc.estore.model.User;
import com.appsdeveloperblog.tutorials.spring.mvc.estore.model.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class UsersController {

    @GetMapping(path="/users/{userId}/albums/{albumId}")
    public ModelAndView getAlbum(@PathVariable("userId") String userId,
                                @PathVariable("albumId") String albumId) {
        ModelAndView modelAndView = new ModelAndView("album");
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("albumId", albumId);
        return modelAndView;
    }

    @GetMapping(path="/users")
    public ModelAndView getUsers(@RequestParam(name="limit", defaultValue="30") int limit) {

        ModelAndView modelAndView = new ModelAndView("users");
        return modelAndView;
    }

    @PostMapping(path = "/users")
    @ResponseBody
    public ResponseEntity<UserRest> createUser(@RequestBody User user) {
        UserRest returnValue = new UserRest(
                UUID.randomUUID().toString(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }

    @GetMapping(path = "/signup")
    public String signupFor()
    {
        return "signup";
    }}
//nurlan aswhimob...