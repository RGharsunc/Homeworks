package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("message", "WELCOME");
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {
        List<UserEntity> userList = userRepository.findAll();

        modelMap.addAttribute("userList", userList);

        return "admin/users";
    }

    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        return "admin/addUser";
    }

    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity, @RequestParam("image") MultipartFile image) throws IOException {
        //upload file
        File dir = new File("D:\\springdemo-files\\upload\\");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // Create the file on server
        String profilePic = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        File serverFile = new File(dir.getAbsolutePath() + "\\" + profilePic);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(image.getBytes());
        stream.close();
        userEntity.setProfilePic(profilePic);
        userRepository.save(userEntity);
        return "redirect:/admin/users";
    }





    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        UserEntity userEntity = userRepository.findOne(userId);

        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }

    @ResponseBody
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public byte[] getImageAsByteArray(@RequestParam("filename") String filename) throws Exception {
        InputStream in = new FileInputStream("D:\\springdemo-files\\upload\\" + filename);
        return org.apache.commons.io.IOUtils.toByteArray(in);
    }





    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        UserEntity userEntity = userRepository.findOne(userId);

        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }

    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") UserEntity user) {

        userRepository.updateUser(user.getNickname(), user.getFirstName(),
                user.getLastName(), user.getPassword(), user.getId());
        userRepository.flush();
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        userRepository.delete(userId);
        userRepository.flush();
        return "redirect:/admin/users";
    }



    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

}
