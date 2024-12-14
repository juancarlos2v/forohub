package com.alura.forohub.services;

import com.alura.forohub.dto.TopicDTO;
import com.alura.forohub.entities.Topic;

import java.util.List;

public interface TopicService {

    void addTopic(TopicDTO topic);
    List<TopicDTO> getAllTopics();
    TopicDTO getTopicById(Long id);
    void updateTopic(Long id,TopicDTO topic);
    void deleteTopic(Long id);
}
