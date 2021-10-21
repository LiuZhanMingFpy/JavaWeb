package com.example.demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Mood {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tittle;
	private String content;
	private String createTime;
	private String image;
	
	protected Mood() {

	}

	public Mood(Long id, String tittle, String content, String createTime, String image) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.content = content;
		this.createTime = createTime;
		this.image = image;
		
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return tittle;
	}

	public void setTitle(String tittle) {
		this.tittle = tittle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Mood [id=" + id + ", tittle=" + tittle + ", content=" + content + ", createTime=" + createTime
				+ ", image=" + image + "]";
	}

	

}
