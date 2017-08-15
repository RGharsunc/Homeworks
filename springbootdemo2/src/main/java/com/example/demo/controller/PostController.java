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

import java.util.List;

/**
 * Created by Vardan on 04.08.2017.
 */
@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/post/{id}")
    public String postById(@PathVariable long id, ModelMap modelMap) {
        PostEntity postEntity = postRepository.findOne(id);
        List<CategoryEntity> categoryEntityList=categoryRepository.findAll();

        modelMap.addAttribute("post", postEntity);
        modelMap.addAttribute("categories", categoryEntityList);
        return "postsById";

    }


}
