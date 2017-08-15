package com.example.demo.controller;

import com.example.demo.model.CategoryEntity;
import com.example.demo.model.PostEntity;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

/**
 * Created by Vardan on 22.07.2017.
 */
@Controller
public class AdminController {

    @Autowired
    private  PostRepository postRepository;

    @Autowired
    private  CategoryRepository categoryRepository;

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String toAdminJSP(ModelMap modelMap) {
        List<PostEntity> posts = postRepository.findAll();
        modelMap.addAttribute("posts", posts);
        List<CategoryEntity> categories = categoryRepository.findAll();
        modelMap.addAttribute("categories", categories);
        return "admin";
    }

    @RequestMapping(value = "/admin/add/category", method = RequestMethod.POST)
    public String addCategorie(@ModelAttribute("category") CategoryEntity category) {
        categoryRepository.save(category);
        return "redirect:/admin";

    }

    @RequestMapping(value = "/admin/add/post", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("post") PostEntity post,
                          @RequestParam("image") MultipartFile image
    ) throws IOException {
        //file upload
        File dir = new File("d:\\java");
        if (!dir.exists()) {
            dir.mkdir();
        }
        //create the file on server
        String postPic = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        File serverFile = new File(dir.getAbsolutePath() + "\\" + postPic);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
        stream.write(image.getBytes());
        stream.close();
        post.setPostPic(postPic);
        postRepository.save(post);

        return "redirect:/admin";
    }

    @ResponseBody
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public byte[] getImageAsByteArray(@RequestParam("filename") String filename) throws Exception {
        InputStream in = new FileInputStream("d:\\java\\" + filename);
        return org.apache.commons.io.IOUtils.toByteArray(in);
    }

    @RequestMapping(value = "/admin/post/remove/{id}", method = RequestMethod.GET)
    public String removePost(@PathVariable("id") long id) {
        postRepository.delete(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/admin/post/update")
    public String updatePost(@RequestParam("currentId") long id, @ModelAttribute PostEntity post) {
        postRepository.updatePost(post.getTitle(), post.getDescription(), post.getCategoryId(), id);
        return "redirect:/admin";
    }
}
