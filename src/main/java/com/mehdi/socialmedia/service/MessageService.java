package com.mehdi.socialmedia.service;

import com.mehdi.socialmedia.models.Chat;
import com.mehdi.socialmedia.models.Message;
import com.mehdi.socialmedia.models.User;

import java.util.List;

public interface MessageService {

    public Message createMessage(User user, Integer chatId, Message req) throws Exception;
    public List<Message> findChatsMessages(Integer chatId) throws Exception;

}
