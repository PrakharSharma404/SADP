package com.ethicalfirewall.m1.service;

import com.ethicalfirewall.m1.model.AdminUser;
import com.ethicalfirewall.m1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AdminUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AdminUser createUser(AdminUser user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
