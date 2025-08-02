package com.cefr.Cefrify.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserSubmission {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
