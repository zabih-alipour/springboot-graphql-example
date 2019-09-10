package com.alipour.learning.sptingbootgraphql.dto;

import lombok.Data;

@Data
public class CommentInputRequest {
    private Long postId;
    private String content;
    private String commenterEmail;
}
