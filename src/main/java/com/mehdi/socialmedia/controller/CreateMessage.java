package com.mehdi.socialmedia.controller;

import com.mehdi.socialmedia.models.Message;
import com.mehdi.socialmedia.models.User;
import com.mehdi.socialmedia.service.MessageService;
import com.mehdi.socialmedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreateMessage {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;


    @PostMapping("/api/message/chat/{chatId}")
    public Message createMessage(@RequestBody Message req,
                                 @RequestHeader ("Authorization") String jwt,
                                 @PathVariable Integer chatId
                                 ) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Message message = messageService.createMessage(user,chatId,req);
        return message;

    }

    @GetMapping("/api/message/chat/{chatId}")
    public List<Message> findChatMessage(
                                 @RequestHeader ("Authorization") String jwt,
                                 @PathVariable Integer chatId
    ) throws Exception {
        User user = userService.findUserByJwt(jwt);

        List<Message> message = messageService.findChatsMessages(chatId);
        return message;

    }
}
