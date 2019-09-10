package com.alipour.learning.sptingbootgraphql.dto;

import lombok.Data;

@Data
public class PostInputRequest {
    String title;
    String content;
    Long authorId;
}
