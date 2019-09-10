package com.alipour.learning.sptingbootgraphql.resolvers.queries;

import com.alipour.learning.sptingbootgraphql.model.Post;
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
public class PostQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PostRepository postRepository;

    public List<Post> recentPosts(Integer limit, Integer offset, String orderBy) {
        log.info("recentPosts, params: {}, {}", limit, offset);
        PageRequest pageRequest = PageRequest.of(limit, offset, Sort.Direction.DESC, orderBy);
        return postRepository.findAll(pageRequest).getContent();
    }

    public Post getPost(Long id) {
        return postRepository.getOne(id);
    }

}
