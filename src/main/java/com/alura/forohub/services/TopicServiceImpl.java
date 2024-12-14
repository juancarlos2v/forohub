package com.alura.forohub.services;

import com.alura.forohub.dto.TopicDTO;
import com.alura.forohub.entities.Topic;
import com.alura.forohub.exceptions.RequestException;
import com.alura.forohub.repositories.TopicRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRespository topicRespository;

    @Override
    public List<TopicDTO> getAllTopics() {
        return topicRespository.findAll().stream().map(TopicDTO::new).collect(Collectors.toList()) ;
    }

    @Override
    public TopicDTO getTopicById(Long id) {
        Topic topic= topicRespository.findById(id).orElseThrow(()-> new RequestException("404","Topico no encontrado"));

        return TopicDTO.builder()
                .author(topic.getAuthor())
                .title(topic.getTitle())
                .message(topic.getMessage())
                .creation(topic.getCreation())
                .build();
    }

    @Override
    public void addTopic(TopicDTO topic) {

        Date date= new Date();
        Topic newTopic = Topic.builder()
                .title(topic.getTitle())
                .author(topic.getAuthor())
                .creation(date)
                .message(topic.getMessage())
                .build();
        topicRespository.save(newTopic);
    }

    @Override
    public void updateTopic(Long id, TopicDTO topictUpdate) {
        Topic topic= topicRespository.findById(id).orElseThrow(()-> new RequestException("404","Topico no encontrado"));
        topic.setTitle(topictUpdate.getTitle());
        topic.setAuthor(topictUpdate.getAuthor());
        topic.setMessage(topictUpdate.getMessage());
        topicRespository.save(topic);
    }

    @Override
    public void deleteTopic(Long id) {
        Topic topic= topicRespository.findById(id).orElseThrow(()-> new RequestException("404","Topico no encontrado"));
        topicRespository.delete(topic);
    }
}
