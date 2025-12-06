package com.ethicalfirewall.m1.controller;

import com.ethicalfirewall.m1.model.AdminUser;
import com.ethicalfirewall.m1.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@CrossOrigin(origins = "*") // Allow for simple testing from static frontend
public class AdminController {

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
        return adminService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
    }
}
