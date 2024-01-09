package com.mehdi.socialmedia.repository;

import com.mehdi.socialmedia.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("select p from  Post p where p.user.id=:userId")
    List<Post> findByBOrderByUserId(Integer userId);
}
