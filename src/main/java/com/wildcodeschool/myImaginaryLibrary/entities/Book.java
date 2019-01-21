package com.wildcodeschool.myImaginaryLibrary.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String title;
    private String author;
    private String description;

    public Book() {  }

    public Book(String title, String author, String description) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setDescription(description);
    }
    
    
	public Book(Long id, String title, String author, String description) {
        this.setId(id);
        this.setTitle(title);
        this.setAuthor(author);
        this.setDescription(description);
    }

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='"+ description+'\''+
                '}';
    }
}