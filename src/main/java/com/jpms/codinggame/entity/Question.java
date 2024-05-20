package com.jpms.codinggame.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private int level;

    @Column
    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String answer;

    @Column
    @Enumerated(EnumType.STRING)
    private LanguageType languageType;

    @Column
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
}
