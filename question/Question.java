package com.mysite.sbb.question;
import jakarta.persistence.ManyToOne;
import com.mysite.sbb.user.SiteUser;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import jakarta.persistence.ManyToMany;

@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length =200)
	private String subject;
	
	@Column(columnDefinition ="TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	 @Column(columnDefinition = "integer default 0")
     @NotNull
     private Integer views = 0;
	
	 @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) 
	 private List<Answer> answerList; 
	 
	 @ManyToOne
     private SiteUser author;
	 
	 private LocalDateTime modifyDate;
	 
	 @ManyToMany
     Set<SiteUser> voter;
	 
	 
	 

}