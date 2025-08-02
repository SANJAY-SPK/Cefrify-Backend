package com.cefr.Cefrify.controller;

import com.cefr.Cefrify.model.Question;
import com.cefr.Cefrify.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cefrify/api/questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepo;

    @GetMapping("/round/{roundNumber}")
    public List<Question> getQuestionsByRound(@PathVariable int roundNumber) {
        return questionRepo.findByRoundNumber(roundNumber);
    }
}
