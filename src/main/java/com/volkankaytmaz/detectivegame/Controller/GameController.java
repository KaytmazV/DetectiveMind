package com.volkankaytmaz.detectivegame.controller;

import com.volkankaytmaz.detectivegame.model.Answer;
import com.volkankaytmaz.detectivegame.model.Person;
import com.volkankaytmaz.detectivegame.model.Question;
import com.volkankaytmaz.detectivegame.service.AnswerService;
import com.volkankaytmaz.detectivegame.service.PersonService;
import com.volkankaytmaz.detectivegame.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class GameController {

    private final PersonService personService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final Random random = new Random();

    @Autowired
    public GameController(PersonService personService, QuestionService questionService, AnswerService answerService) {
        this.personService = personService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/interrogate")
    public Answer interrogate(@RequestParam int personId, @RequestParam int questionId) {
        Person person = personService.getPersonById(personId);
        Question question = questionService.getQuestionById(questionId);

        if (person == null || question == null) {
            return null;
        }

        String answerText = generateAnswer(person, question);

        Answer answer = new Answer();
        answer.setPersonId(personId);
        answer.setQuestionId(questionId);
        answer.setAnswerText(answerText);

        return answerService.saveAnswer(answer);
    }

    private String generateAnswer(Person person, Question question) {
        if (person.isGuilty()) {
            return generateGuiltyAnswer(question);
        } else {
            return generateInnocentAnswer(person, question);
        }
    }

    private String generateGuiltyAnswer(Question question) {
        String[] evasiveAnswers = {
                "I'd rather not answer that question.",
                "I don't recall the details you're asking about.",
                "Can we move on to another topic?",
                "I'm not comfortable discussing that.",
                "I think you should ask someone else about that."
        };
        return evasiveAnswers[random.nextInt(evasiveAnswers.length)];
    }

    private String generateInnocentAnswer(Person person, Question question) {
        if (question.getQuestionText().contains("Where were you")) {
            return person.getAlibi();
        }

        String[] innocentAnswers = {
                "I have nothing to hide. What exactly do you want to know?",
                "I'm happy to help with your investigation. What else can I tell you?",
                "I'm not sure how this is relevant, but I'll answer to the best of my ability.",
                "I was not involved in any way. Is there anything specific you're looking for?",
                "I'm as surprised as you are about what happened. How can I assist further?"
        };
        return innocentAnswers[random.nextInt(innocentAnswers.length)];
    }
}