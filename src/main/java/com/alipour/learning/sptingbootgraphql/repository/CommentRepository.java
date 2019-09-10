package com.alipour.learning.sptingbootgraphql.repository;

import com.alipour.learning.sptingbootgraphql.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @EntityGraph(attributePaths = "post")
    @Query("select distinct c from Comment c " +
            "where c.post.id=:postId")
    Page<Comment> findAllByPost(@Param("postId") Long postId, Pageable pageable);
}
