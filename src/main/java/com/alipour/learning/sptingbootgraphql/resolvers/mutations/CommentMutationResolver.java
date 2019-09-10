package com.alipour.learning.sptingbootgraphql.resolvers.mutations;

import com.alipour.learning.sptingbootgraphql.dto.CommentInputRequest;
import com.alipour.learning.sptingbootgraphql.model.Comment;
import com.alipour.learning.sptingbootgraphql.model.Post;
import com.alipour.learning.sptingbootgraphql.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentMutationResolver extends ParentMutation {

    @Autowired
    private CommentRepository commentRepository;

    public Comment newComment(CommentInputRequest commentInputRequest) {
        Comment comment = new Comment();
        comment.setPost(new Post(commentInputRequest.getPostId()));
        comment.setCommenterEmail(commentInputRequest.getCommenterEmail());
        comment.setContent(commentInputRequest.getContent());
        return commentRepository.save(comment);
    }
}
