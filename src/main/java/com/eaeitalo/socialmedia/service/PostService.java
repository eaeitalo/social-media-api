package com.eaeitalo.socialmedia.service;

import com.eaeitalo.socialmedia.model.Post;
import com.eaeitalo.socialmedia.model.User;
import com.eaeitalo.socialmedia.repository.PostRepository;
import com.eaeitalo.socialmedia.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Post Service - Lógica de negócio para posts
 * @author @eaeitalo
 */
@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public PostService(PostRepository postRepository, UserRepository userRepository,
                       NotificationService notificationService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public Post createPost(Long userId, String content) {
        User author = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Post post = new Post(content, author);
        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAllOrderByCreatedAtDesc();
    }

    public List<Post> getUserPosts(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return postRepository.findByAuthorOrderByCreatedAtDesc(user);
    }

    public List<Post> getUserFeed(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        List<Long> followingIds = user.getFollowing().stream()
                .map(User::getId)
                .toList();

        return postRepository.findPostsByAuthorsOrderByCreatedAtDesc(followingIds);
    }

    public void likePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        post.like(user);
        postRepository.save(post);

        notificationService.sendLikeNotification(
                postId,
                user.getUsername(),
                post.getAuthor().getUsername()
        );
    }

    public void unlikePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        post.unlike(user);
        postRepository.save(post);
    }

    public List<Post> searchPosts(String keyword) {
        return postRepository.findByContentContaining(keyword);
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));
        postRepository.delete(post);
    }
}
