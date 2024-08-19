package com.example.UploadImageToAws.Service;

import com.example.UploadImageToAws.DTO.UserRequestDTO;
import com.example.UploadImageToAws.Model.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    public User createUser(MultipartFile file,String name,String gender);

    public User getSingleUser(int id);

    public User updateUser(MultipartFile multipartFile,String name,String gender,int id);
}
