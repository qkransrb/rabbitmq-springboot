package com.example.rabbitmqspringboot.controller;

import com.example.rabbitmqspringboot.model.QueueObject;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class DefaultController {

    private final AmqpTemplate defaultExchange;

    @PostMapping("/default")
    public ResponseEntity<String> sendMessageWithDefaultExchange() {
        QueueObject object = new QueueObject("default", LocalDateTime.now());
        defaultExchange.convertAndSend(object);
        return new ResponseEntity<>("Message is published", HttpStatus.OK);
    }
}
