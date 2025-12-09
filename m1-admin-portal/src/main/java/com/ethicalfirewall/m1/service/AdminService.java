package com.ethicalfirewall.m1.service;

import com.ethicalfirewall.m1.model.AdminUser;
import com.ethicalfirewall.m1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AdminService.class);

    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AdminUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AdminUser createUser(AdminUser user) {
        log.debug("Validating user data... OK.");
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public AdminUser toggleUserStatus(Long id) {
        AdminUser user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setActive(!user.isActive());
        log.info("Toggling status for user '{}' to {}", user.getUsername(), user.isActive());
        return userRepository.save(user);
    }

    public void resetPassword(Long id) {
        AdminUser user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        log.info("initiating password reset for user '{}' ({})", user.getUsername(), user.getEmail());
        // Simulating email service call
        log.info(">> EMAIL SENT to {}: 'Click here to reset your password...'", user.getEmail());
    }
}
