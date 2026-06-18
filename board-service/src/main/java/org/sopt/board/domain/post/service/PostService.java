package org.sopt.board.domain.post.service;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.board.domain.post.dto.request.PostCreateRequest;
import org.sopt.board.domain.post.dto.request.PostUpdateRequest;
import org.sopt.board.domain.post.dto.response.PostResponse;
import org.sopt.board.domain.post.entity.Post;
import org.sopt.board.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long createPost(PostCreateRequest request) {
        Long temporarywriterId = 1L;

        Post post = new Post(
                temporarywriterId, request.title(), request.content()
        );

        Post savePost = postRepository.save(post);
        return savePost.getId();
    }

    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream().map(PostResponse::from).toList();
    }

    public PostResponse findPostById(Long postId){
        return PostResponse.from(postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다.")));
    }

    @Transactional
    public Long updatePost(Long postId, PostUpdateRequest request) {

        Post findPost = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        findPost.update(request.content());

        return findPost.getId();
    }

    @Transactional
    public void deletePost(Long postId){
        postRepository.deleteById(postId);
    }
}
