package com.mehdi.socialmedia.controller;

import com.mehdi.socialmedia.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateMessage {
    @Autowired
    private MessageService messageService;


}
