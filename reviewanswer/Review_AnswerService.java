package com.mysite.sbb.reviewanswer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.review.Review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service

public class Review_AnswerService {
	private final Review_AnswerRepository review_answerRepository;


	public void create(Review review, String content) {
        Review_Answer review_answer = new Review_Answer();
        review_answer.setContent(content);
        review_answer.setCreateDate(LocalDateTime.now());
        review_answer.setReview(review);
        this.review_answerRepository.save(review_answer);
    }
	
}
