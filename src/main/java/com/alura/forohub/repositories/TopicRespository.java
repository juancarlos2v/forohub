package com.alura.forohub.repositories;

import com.alura.forohub.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRespository extends JpaRepository<Topic, Long> {
}
