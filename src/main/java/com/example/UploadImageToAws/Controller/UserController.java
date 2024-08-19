package com.example.UploadImageToAws.Controller;

import com.example.UploadImageToAws.DTO.UserRequestDTO;
import com.example.UploadImageToAws.Model.User;
import com.example.UploadImageToAws.Service.ImageUploader;
import com.example.UploadImageToAws.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageUploader imageUploader;

    @PostMapping("/post")
    public User saveUser(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender){
        User user1 = userService.createUser(file,name,gender);
        return user1;
    }

    @GetMapping("/get/user")
    public User getSingleUser(@RequestParam int id){
        User singleUser = userService.getSingleUser(id);
        return singleUser;
    }

    @PutMapping("/update")
    public User updateUser(@RequestParam(value = "file",required = false) MultipartFile multipartFile,
                           @RequestParam ("name") String name,
                           @RequestParam("gender")String gender,
                           @RequestParam("id") int id
                           ){
        User user = userService.updateUser(multipartFile, name, gender, id);
        return user;

    }
}
