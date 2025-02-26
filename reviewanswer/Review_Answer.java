package com.mysite.sbb.reviewanswer;

import java.time.LocalDateTime;


import com.mysite.sbb.review.Review;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.ManyToOne;
import lombok.Getter; 
import lombok.Setter; 

@Getter 
@Setter 
@Entity
public class Review_Answer {
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
	
	@Column(columnDefinition = "TEXT") 
    private String content; 

    private LocalDateTime createDate; 
    
    @ManyToOne
	private Review review;
}
