package com.ethicalfirewall.m1.controller;

import com.ethicalfirewall.m1.model.AdminUser;
import com.ethicalfirewall.m1.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*") // Allow for simple testing from static frontend
public class AdminController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AdminController.class);

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<AdminUser> getAllUsers() {
        return adminService.getAllUsers();
    }

    @PostMapping
    public AdminUser createUser(@RequestBody AdminUser user) {
        log.debug("Received request to create user: {}", user.getUsername());
        AdminUser createdUser = adminService.createUser(user);
        log.info("User '{}' created successfully. ID: {}", createdUser.getUsername(), createdUser.getId());
        return createdUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
    }
}
