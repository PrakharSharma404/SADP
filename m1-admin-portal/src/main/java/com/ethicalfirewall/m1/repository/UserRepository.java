package com.ethicalfirewall.m1.repository;

import com.ethicalfirewall.m1.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AdminUser, Long> {
}
