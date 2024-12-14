package com.alura.forohub.dto;

import com.alura.forohub.entities.Topic;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicDTO {

    private String title;
    private String message;
    private Date creation;
    private String author;

    public TopicDTO(Topic topic) {
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creation = topic.getCreation();
        this.author = topic.getAuthor();
    }
}
