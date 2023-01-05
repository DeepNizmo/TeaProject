package com.spring.henallux.teaProject.dataAccess.dao;

import com.spring.henallux.teaProject.dataAccess.entity.UserEntity;
import com.spring.henallux.teaProject.dataAccess.repository.UserRepository;
import com.spring.henallux.teaProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.teaProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDAO implements UserDataAccess{

    private UserRepository userRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public User save(User user) {
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        userEntity = userRepository.save(userEntity);
        return providerConverter.userEntityToUserModel(userEntity);
    }

    @Override
    public User findByUsername(String username) {
        return providerConverter.userEntityToUserModel(userRepository.findByUsername(username));
    }

    public ArrayList<User> getAllUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        ArrayList<User> users = new ArrayList<>();
        for(UserEntity userEntity : userEntityList ) {
            User user = providerConverter.userEntityToUserModel(userEntity);
            users.add(user);
        }
        return users;
    }
}
