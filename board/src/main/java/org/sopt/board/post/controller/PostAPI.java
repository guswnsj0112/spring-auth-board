package org.sopt.board.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.sopt.board.post.dto.request.PostCreateRequest;
import org.sopt.board.post.dto.response.PostResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(name = "Post", description = "게시글 API")
public interface PostAPI {
    @Operation(summary = "게시글 생성", description = "게시글을 생성합니다.")
    Long createPost(
            @RequestBody PostCreateRequest request
    );

    @Operation(summary = "게시글 리스트 조회", description = "게시글 리스트를 조회합니다.")
    List<PostResponse> findPosts(
    );


    @Operation(summary = "게시글 상세 조회", description = "게시글 상세 조회합니다.")
    PostResponse findPostById(
            @PathVariable Long postId
    );
    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    void deletePost(
            @PathVariable Long postId
    );
}
