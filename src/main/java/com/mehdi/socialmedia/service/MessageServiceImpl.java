package com.mehdi.socialmedia.service;

import com.mehdi.socialmedia.models.Chat;
import com.mehdi.socialmedia.models.Message;
import com.mehdi.socialmedia.models.User;
import com.mehdi.socialmedia.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ChatService chatService;


    @Override
    public Message createMessage(User user, Integer userId, Integer chatId, Message req) throws Exception {


        Chat chat = chatService.findChatById(chatId);
        Message message =new Message();

        message.setChat(null);
        message.setContent(req.getContent());
        message.setImage(req.getImage());
        message.setUser(user);
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findChatsMessages(Integer chatId) throws Exception {
        Chat chat = chatService.findChatById(chatId);
        return messageRepository.findByChatId(chatId);
    }
}
