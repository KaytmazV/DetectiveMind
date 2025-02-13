package com.volkankaytmaz.detectivegame.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(columnDefinition = "TEXT")
    private String question_text;

    private int questionPersonId;
}
