package com.mysite.sbb.answer;

import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.question.Question;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.mysite.sbb.DataNotFoundException;
@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;


    public Answer create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
        return answer;
    }
    
    public Answer getAnswer(Integer id) {
        Optional<Answer> answer = this.answerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }
    
    
    public Page<Answer> getAnswerList(Question question, int page, String answerOrderMethod) 
    {
		List<Sort.Order> sorts = new ArrayList<>();
		if (answerOrderMethod.startsWith("recommend")) {
			sorts.add(Sort.Order.desc("voter"));
		}
		else {
			sorts.add(Sort.Order.desc("createDate"));
		}
		Pageable pageable = PageRequest.of(page, 5, Sort.by(sorts));
		return this.answerRepository.findByQuestion(question, pageable);
	}
    
    
    
    public void modify(Answer answer, String content) {
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }
    
    public void delete(Answer answer) {
        this.answerRepository.delete(answer);
    }
    
    public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }
}
