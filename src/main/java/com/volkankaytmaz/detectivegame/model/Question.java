package com.volkankaytmaz.detectivegame.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String questionText;

    private int questionPersonId;

    public Question(String questionText, int questionPersonId) {
        this.questionText = questionText;
        this.questionPersonId = questionPersonId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getQuestionPersonId() {
        return questionPersonId;
    }

    public void setQuestionPersonId(int questionPersonId) {
        this.questionPersonId = questionPersonId;
    }
}