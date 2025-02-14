package com.volkankaytmaz.detectivegame.service;

import com.volkankaytmaz.detectivegame.model.Answer;
import com.volkankaytmaz.detectivegame.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    public Answer getAnswerById(int id) {
        return answerRepository.findById(id).orElse(null);
    }

    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public void deleteAnswer(int id) {
        answerRepository.deleteById(id);
    }
}