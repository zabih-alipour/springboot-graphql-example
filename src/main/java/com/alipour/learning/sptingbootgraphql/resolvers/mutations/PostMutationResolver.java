package com.alipour.learning.sptingbootgraphql.resolvers.mutations;

import com.alipour.learning.sptingbootgraphql.dto.PostInputRequest;
import com.alipour.learning.sptingbootgraphql.model.Author;
import com.alipour.learning.sptingbootgraphql.model.Post;
import com.alipour.learning.sptingbootgraphql.model.Status;
import com.alipour.learning.sptingbootgraphql.repository.AuthorRepository;
import com.alipour.learning.sptingbootgraphql.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostMutationResolver extends ParentMutation {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PostRepository postRepository;

    public Post newPost(PostInputRequest postInputRequest) {
        Author author = authorRepository.findById(postInputRequest.getAuthorId())
                .orElse(new Author("Alipour", 31));
        if (author.getId() == null)
            authorRepository.save(author);
        Post post = Post.builder()
                .title(postInputRequest.getTitle())
                .content(postInputRequest.getContent())
                .author(author)
                .status(Status.ACTIVE)
                .build();
        post = postRepository.save(post);
        return post;
    }
}
