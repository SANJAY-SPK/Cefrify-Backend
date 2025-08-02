package com.cefr.Cefrify.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Answer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserSubmission user;

    @ManyToOne
    private Question question;

    private String audioFileName; // Saved user audio, if any
    private String transcription; // Optionally store STT text
    private int roundNumber;
}
