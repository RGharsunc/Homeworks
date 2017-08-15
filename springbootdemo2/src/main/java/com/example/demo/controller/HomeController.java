package com.example.demo.controller;

import com.example.demo.model.CategoryEntity;
import com.example.demo.model.PostEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Vardan on 21.07.2017.
 */
@Controller
public class HomeController {

    @Autowired
   private  PostRepository postRepository;

    @Autowired
    private  CategoryRepository categoryRepository;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String toHomeJSP(ModelMap modelMap) {
        List<PostEntity> posts = postRepository.findAll();
        List<CategoryEntity> categories = categoryRepository.findAll();

        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("posts", posts);
        return "home";
    }

    @RequestMapping(value = "/home/categories/show/{id}")
    public String showPostsByCategories(@PathVariable long id, ModelMap modelMap) {
        List<PostEntity> posts = postRepository.findByCategoryId(id);
        List<CategoryEntity> categories = categoryRepository.findAll();
        modelMap.addAttribute("posts",posts);
        modelMap.addAttribute("categories", categories);
        return "home";
    }

    }




