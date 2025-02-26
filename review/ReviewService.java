package com.mysite.sbb.review;

import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {
	 private final ReviewRepository reviewRepository;

	    public List<Review> getList() {
	        return this.reviewRepository.findAll();
	    }
	    
	    public Review getReview(Integer id) {  
	        Optional<Review> review = this.reviewRepository.findById(id);
	        if (review.isPresent()) {
	            return review.get();
	        } else {
	            throw new DataNotFoundException("review not found");
	        }
	    }
	    
	}