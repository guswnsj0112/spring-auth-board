package org.sopt.board.post.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.board.post.dto.request.PostCreateRequest;
import org.sopt.board.post.dto.request.PostUpdateRequest;
import org.sopt.board.post.dto.response.PostResponse;
import org.sopt.board.post.service.PostService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public Long createPost(
            @Valid @RequestBody PostCreateRequest request
    ){
        return postService.createPost(request);
    }

    @GetMapping
    public List<PostResponse> findPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostResponse findPostById(
            @PathVariable Long postId
    ){
        return postService.findPostById(postId);
    }

    @PatchMapping("/{postId}")
    public PostResponse updatePost(
            @Valid @RequestBody PostUpdateRequest request,
            @PathVariable Long postId
    ){
        Long post = postService.updatePost(postId, request);
        return postService.findPostById(post);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(
            @PathVariable Long postId
    ){
        postService.deletePost(postId);
    }
}
