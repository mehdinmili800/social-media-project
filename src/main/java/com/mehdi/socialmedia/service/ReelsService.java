package com.mehdi.socialmedia.service;

import com.mehdi.socialmedia.models.Reels;
import com.mehdi.socialmedia.models.User;

import java.util.List;

public interface ReelsService {

    public Reels createReel(Reels reels, User user);

    public List<Reels> findAllReels();
    public List<Reels>findUsersReel(Integer userId) throws Exception;

}
