package com.example.demo.controller;

import com.example.demo.model.CategoryEntity;
import com.example.demo.model.PostEntity;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(ModelMap modelMap) {

        return "redirect:home";
    }



}
