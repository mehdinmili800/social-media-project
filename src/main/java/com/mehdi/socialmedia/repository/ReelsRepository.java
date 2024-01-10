package com.mehdi.socialmedia.repository;

import com.mehdi.socialmedia.models.Reels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReelsRepository extends JpaRepository<Reels,Integer> {

    public List<Reels> findByUserId(Integer userId);
}
