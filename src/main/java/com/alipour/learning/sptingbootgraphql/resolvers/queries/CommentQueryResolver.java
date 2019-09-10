package com.alipour.learning.sptingbootgraphql.resolvers.queries;

import com.alipour.learning.sptingbootgraphql.model.Comment;
import com.alipour.learning.sptingbootgraphql.model.Post;
import com.alipour.learning.sptingbootgraphql.repository.CommentRepository;
import com.alipour.learning.sptingbootgraphql.repository.PostRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getPostCommentsInPaganition(Long postId, Integer limit, Integer offset, String orderBy) {
        PageRequest pageRequest = PageRequest.of(limit, offset, Sort.Direction.DESC, orderBy);
        return commentRepository.findAllByPost(postId, pageRequest).getContent();
    }

}
