package com.cefr.Cefrify.repository;

import com.cefr.Cefrify.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByRoundNumber(int roundNumber);
}
