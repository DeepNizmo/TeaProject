package com.spring.henallux.teaProject.dataAccess.repository;

import com.spring.henallux.teaProject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);

}