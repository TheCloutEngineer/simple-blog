package io.cloutengineer.simpleblog.repository;

import io.cloutengineer.simpleblog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
