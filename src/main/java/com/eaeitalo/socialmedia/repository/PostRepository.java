package com.eaeitalo.socialmedia.repository;

import com.eaeitalo.socialmedia.model.Post;
import com.eaeitalo.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Post Repository - Operações de banco para Post
 * @author @eaeitalo
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByAuthorOrderByCreatedAtDesc(User author);

    @Query("SELECT p FROM Post p WHERE p.author.id IN :userIds ORDER BY p.createdAt DESC")
    List<Post> findPostsByAuthorsOrderByCreatedAtDesc(@Param("userIds") List<Long> userIds);

    @Query("SELECT p FROM Post p ORDER BY p.createdAt DESC")
    List<Post> findAllOrderByCreatedAtDesc();

    @Query("SELECT COUNT(p) FROM Post p WHERE p.author.id = :userId")
    Long countPostsByUserId(@Param("userId") Long userId);

    @Query("SELECT p FROM Post p WHERE p.content LIKE %:keyword% ORDER BY p.createdAt DESC")
    List<Post> findByContentContaining(@Param("keyword") String keyword);
}
