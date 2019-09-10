package com.alipour.learning.sptingbootgraphql.repository;

import com.alipour.learning.sptingbootgraphql.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
