package com.mysite.sbb.reviewanswer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;
import com.mysite.sbb.review.Review;
import com.mysite.sbb.review.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/review_answer")
@RequiredArgsConstructor
@Controller
public class Review_AnswerController {
		
	  private final ReviewService reviewService;
	  
	  private final Review_AnswerService review_answerService;
	  
	  @PostMapping("/create/{id}")
	  public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
	        Review review= this.reviewService.getReview(id);
	        
	        this.review_answerService.create(review, content);
	        
	        
	        return String.format("redirect:/review/detail/%s", id);
	    }
}
