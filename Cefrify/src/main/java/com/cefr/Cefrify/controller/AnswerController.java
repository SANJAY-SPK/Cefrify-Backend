package com.cefr.Cefrify.controller;

import com.cefr.Cefrify.model.Answer;
import com.cefr.Cefrify.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cefrify/api/answers")
public class AnswerController {

    @Autowired
    private AnswerRepository answerRepo;

    // Accepts user answer audio file (e.g., for each question), and other info as needed
    @PostMapping("/upload")
    public String uploadAnswer(
            @RequestParam Long userId,
            @RequestParam Long questionId,
            @RequestParam("file") MultipartFile audioFile
    ) {
        // Save audio file to disk (e.g., in /static/audios/) and record Answer in DB
        // (Writing of service code for file saving will be in the service layer)
        return "Answer received"; // For MVP
    }
}
