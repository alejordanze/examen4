package com.ucbcba.demo.repositories;

import com.ucbcba.demo.entities.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    @Query("select c, count(c) from Comment c group by c.user")
    Iterable<Comment> getTop3();


}
