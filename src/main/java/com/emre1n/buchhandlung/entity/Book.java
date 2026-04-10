package com.emre1n.buchhandlung.entity;

import java.math.BigDecimal;
import java.time.Instant;

public class Book {

	private int id;
	private String title;
	private String author;
	private String isbn;
	private BigDecimal price;
	private Instant createdAt;

	public Book() {
	}

	public Book(String title, String author, String isbn, BigDecimal price) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
	}

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
