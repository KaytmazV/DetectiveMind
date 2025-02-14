package com.volkankaytmaz.detectivegame.repository;

import com.volkankaytmaz.detectivegame.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}