package org.sopt.board.domain.post.dto.response;

import org.sopt.board.domain.post.entity.Post;

public record PostResponse(
        Long id,
        Long writerId,
        String title,
        String content
) {
    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getWriterId(),
                post.getTitle(),
                post.getContent()
        );
    }
}
