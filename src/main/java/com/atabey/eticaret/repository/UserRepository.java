package com.atabey.eticaret.repository;

import com.atabey.eticaret.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
