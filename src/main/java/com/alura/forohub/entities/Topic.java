package com.alura.forohub.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="topico")
public class Topic {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "mensaje")
    private String message;
    @Column(name = "creacion")
    private Date creation;
    @Column(name = "author")
    private String author;

}
