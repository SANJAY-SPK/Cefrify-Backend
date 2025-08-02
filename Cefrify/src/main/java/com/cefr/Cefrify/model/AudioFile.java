package com.cefr.Cefrify.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AudioFile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String filePath;
}
