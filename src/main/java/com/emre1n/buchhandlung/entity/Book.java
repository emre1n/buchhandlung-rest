package com.emre1n.buchhandlung.entity;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "isbn")
	private String isbn;

	@Column(name = "price")
	private BigDecimal price;

	@Column(name = "created_at")
	private Instant createdAt;

	// define constructors
	public Book() {
	}

	public Book(String title, String author, String isbn, BigDecimal price) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
	}

	// runs once before Hibernate inserts a new row,
	// so created_at is set if the app did not set it (similar idea to a DB default).
	@PrePersist
	private void prePersist() {
		if (createdAt == null) {
			createdAt = Instant.now();
		}
	}

	// define getters/setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	// define toString() method
	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", isbn='" + isbn + '\'' +
				", price=" + price +
				", createdAt=" + createdAt +
				'}';
	}
}
