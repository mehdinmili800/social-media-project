package com.mehdi.socialmedia.repository;

import com.mehdi.socialmedia.models.Chat;
import com.mehdi.socialmedia.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,Integer> {

    public List<Chat> findByUsersId(Integer userId);

    @Query("select c from Chat c WHERE :user member  of c.users AND  :reqUser member of  c.users")
    public  Chat findChatByUsersId(@Param("user")User user,@Param("reqUser") User reqUser);

}
