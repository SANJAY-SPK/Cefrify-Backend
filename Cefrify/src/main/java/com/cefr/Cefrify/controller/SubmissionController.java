package com.cefr.Cefrify.controller;

import com.cefr.Cefrify.model.UserSubmission;
import com.cefr.Cefrify.repository.UserSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cefrify/api")
public class SubmissionController {

    @Autowired
    private UserSubmissionRepository userRepo;

    @PostMapping("/start")
    public ResponseEntity<UserSubmission> startTest(@RequestBody UserSubmission submission) {
        UserSubmission saved = userRepo.save(submission);
        return ResponseEntity.ok(saved);
    }
}
