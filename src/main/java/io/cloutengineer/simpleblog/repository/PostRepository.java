package io.cloutengineer.simpleblog.repository;

import io.cloutengineer.simpleblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
