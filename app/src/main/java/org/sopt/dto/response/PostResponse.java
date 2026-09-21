package org.sopt.dto.response;

import org.sopt.entity.Post;

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
