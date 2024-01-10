package com.mehdi.socialmedia.service;

import com.mehdi.socialmedia.models.Reels;
import com.mehdi.socialmedia.models.User;
import com.mehdi.socialmedia.repository.ReelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsServiceImpl implements ReelsService{
    @Autowired
    private ReelsRepository reelsRepository;
    @Autowired
    private UserService userService;
    @Override
    public Reels createReel(Reels reels, User user) {
        Reels createReel = new Reels();
        createReel.setTitle(reels.getTitle());
        createReel.setUser(user);
        createReel.setVideo(reels.getVideo());
        return reelsRepository.save(createReel);
    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findUsersReel(Integer userId) throws Exception {
        userService.findUserById(userId);
        return reelsRepository.findByUserId(userId);
    }
}
