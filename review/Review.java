package com.mysite.sbb.review;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.reviewanswer.Review_Answer;

import jakarta.persistence.CascadeType; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany; 

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE) 
    private List<Review_Answer> answerList; 
}