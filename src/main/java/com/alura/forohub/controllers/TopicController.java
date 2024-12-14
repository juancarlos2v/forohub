package com.alura.forohub.controllers;

import com.alura.forohub.dto.TopicDTO;
import com.alura.forohub.services.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    public ResponseEntity<String> addTopic(@RequestBody TopicDTO topic) {
        topicService.addTopic(topic);
        return new ResponseEntity<>("Topico creado.", HttpStatus.CREATED);

    }

    @GetMapping
    public List<TopicDTO> getTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDTO> getTopic(@PathVariable Long id) {
        TopicDTO topic = topicService.getTopicById(id);
        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTopic(@PathVariable Long id, @RequestBody TopicDTO topic) {
        topicService.updateTopic(id, topic);
        return new ResponseEntity<>("Topico actualizado.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return new ResponseEntity<>("Topico eliminado.", HttpStatus.OK);
    }
}
