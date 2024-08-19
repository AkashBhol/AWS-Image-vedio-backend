package com.example.UploadImageToAws.Service;

import com.example.UploadImageToAws.Config.BsicUtil;
import com.example.UploadImageToAws.DTO.UserRequestDTO;
import com.example.UploadImageToAws.Model.User;
import com.example.UploadImageToAws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageUploader imageUploader;

    @Override
    @Transactional
    public User createUser(MultipartFile file, String name, String gender) {
        String s = imageUploader.uploadImage(file);
        User user1 = User.builder()
                .name(name)
                .gender(gender)
                .imageUrl(s)
                .build();
        userRepository.save(user1);
//        return user;
        return user1;
    }

    @Override
    public User getSingleUser(int id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public User updateUser(MultipartFile multipartFile, String name, String gender, int id) {
        User user = userRepository.findById(id).get();
        if (BsicUtil.isNullOrEmpty(user)) {
            return user;
        }
        String s = null;
        if (!multipartFile.isEmpty()) {
            s = imageUploader.uploadImage(multipartFile);
        }
        User user1 = User.builder()
                .name(name)
                .gender(gender)
                .imageUrl(s)
                .build();
        return user1;
    }
}
