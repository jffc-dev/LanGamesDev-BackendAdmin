package com.langames.admin.entities.Word;

import jakarta.persistence.*;

@Entity
@Table(name = "Word", schema = "general")
public class WordModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content")
	private String content;

	public WordModel() {
		
	}
	
	public WordModel(String content) {
		super();
		this.content = content;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}