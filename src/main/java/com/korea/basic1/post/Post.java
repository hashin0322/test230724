package com.korea.basic1.post;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String subject;
    private String content;

    private String author;

    private Integer view;
    private Integer hit;

    private LocalDateTime date;
}
