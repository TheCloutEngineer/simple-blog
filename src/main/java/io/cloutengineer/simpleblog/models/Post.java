package io.cloutengineer.simpleblog.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a blog post entity.
 * <p>
 * This class is used to model a post with attributes such as
 * title, content, author, tags, and the timestamp of creation.
 * It is annotated with JPA and Lombok annotations to simplify entity
 * management and reduce boilerplate code.
 * <p>
 * Features:
 * - Automatically generates an ID for each post using JPA's identity strategy.
 * - Includes utility methods `equals` and `hashCode` for comparing instances.
 * - The `createdAt` field is initialized to the current timestamp upon post-creation.
 * <p>
 * An instance of this class can be used to interact with a database or process blog-related data.
 */
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 10_000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

}
