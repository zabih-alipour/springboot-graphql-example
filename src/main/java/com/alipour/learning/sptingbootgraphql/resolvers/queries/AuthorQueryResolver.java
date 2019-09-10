package com.alipour.learning.sptingbootgraphql.resolvers.queries;

import com.alipour.learning.sptingbootgraphql.model.Author;
import com.alipour.learning.sptingbootgraphql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> authorsWithTopPosts() {
        log.info("authorsWithTopPosts");
        return authorRepository.findAuthorsWithPosts();
    }

    public Author getAuthor(Long id) {
        return authorRepository.getOne(id);
    }
}
