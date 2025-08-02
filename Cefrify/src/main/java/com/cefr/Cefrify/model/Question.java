package com.cefr.Cefrify.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roundNumber;        // 1: Text, 2: Audio, 3: Topic
    private String text;            // Question text or topic
    private String audioFileName;   // (for round 2, nullable)
}
