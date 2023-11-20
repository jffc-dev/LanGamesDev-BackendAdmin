package com.langames.admin.entities.Word;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import com.langames.admin.entities.Translate.TranslateDAO;
import com.langames.admin.entities.Translate.TranslateModel;

import jakarta.persistence.*;

@Entity
@Table(name = "Word", schema = "general")
public class WordModel {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "content")
	private String content;

	@CreationTimestamp(source = SourceType.DB)
	private Instant createdOn;
	
	@UpdateTimestamp(source = SourceType.DB)
	private Instant lastUpdatedOn;

	@OneToMany(mappedBy = "word", cascade = CascadeType.ALL)
    private List<TranslateModel> translates;

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

	public List<TranslateModel> getTranslates() {
		return translates;
	}
	public void setTranslates(List<TranslateModel> translates) {
		this.translates = translates;
	}

	public WordDAO toDao(){

		List<TranslateDAO> translatesDao = new ArrayList<>();
		for (TranslateModel translateModel : this.translates) {
			translatesDao.add(translateModel.toDao());
		}

		WordDAO word = new WordDAO(
			this.id,
			this.content,
			this.createdOn,
			this.lastUpdatedOn,
			translatesDao
		);

		return word;
	}

}