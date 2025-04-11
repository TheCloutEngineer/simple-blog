package io.cloutengineer.simpleblog.models;

import io.cloutengineer.simpleblog.repository.CommentRepository;
import io.cloutengineer.simpleblog.repository.PostRepository;
import io.cloutengineer.simpleblog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class BlogModelTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    void testCreatePostWithUserAndComment() {
        User user = User.builder()
                .username("cloutdev")
                .email("clout@example.com")
                .build();
        user = userRepository.save(user);

        Post post = Post.builder()
                .title("Hello World")
                .content("My first blog post!")
                .createdAt(LocalDateTime.now())
                .author(user)
                .build();
        post = postRepository.save(post);

        Comment comment = Comment.builder()
                .content("Nice post!")
                .commenterName("Reader1")
                .createdAt(LocalDateTime.now())
                .post(post)
                .build();
        commentRepository.save(comment);

        assertThat(postRepository.findAll()).hasSize(1);
        assertThat(commentRepository.findAll()).hasSize(1);
        assertThat(userRepository.findAll()).hasSize(1);
        assertThat(post.getAuthor().getUsername()).isEqualTo("cloutdev");
    }
}
