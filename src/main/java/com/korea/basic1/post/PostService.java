package com.korea.basic1.post;


import com.korea.basic1.DataNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final List<Post> posts = new ArrayList<>();
    public List<Post> getAllPosts() {
        return posts;
    }
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void create(String subject, String content) {
        Post p = new Post();
        p.setSubject(subject);
        p.setContent(content);
        p.setDate(LocalDateTime.now());
        p.setHit(0);
        p.setView(0);
        p.setAuthor("홍길동");


        this.postRepository.save(p);
    }

    public Post getPost(Integer id){
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else {
            throw new DataNotFoundException("post not found");
        }
    }

    public void updatePost(Post updatedPost) {
        Post existingPost = getPost(updatedPost.getId());
        if (existingPost != null) {
            existingPost.setSubject(updatedPost.getSubject());
            existingPost.setContent(updatedPost.getContent());
        }
    }

    public void deletePost(Long id) {
        posts.removeIf(post -> post.getId().equals(id));
    }

}
