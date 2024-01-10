package com.mehdi.socialmedia.repository;

import com.mehdi.socialmedia.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
