package com.alipour.learning.sptingbootgraphql.resolvers.mutations;

import com.alipour.learning.sptingbootgraphql.dto.AuthorInputRequest;
import com.alipour.learning.sptingbootgraphql.dto.CommentInputRequest;
import com.alipour.learning.sptingbootgraphql.model.Author;
import com.alipour.learning.sptingbootgraphql.model.Comment;
import com.alipour.learning.sptingbootgraphql.model.Status;
import com.alipour.learning.sptingbootgraphql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private AuthorRepository authorRepository;


    public Author newAuthor(AuthorInputRequest authorInputRequest) {

        Author author = new Author(authorInputRequest.getName(), authorInputRequest.getAge());
        author.setStatus(Status.ACTIVE);
        author = authorRepository.save(author);
        return author;
    }
}
