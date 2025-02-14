package com.volkankaytmaz.detectivegame.repository;

import com.volkankaytmaz.detectivegame.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}