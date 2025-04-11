package io.cloutengineer.simpleblog.repository;

import io.cloutengineer.simpleblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
