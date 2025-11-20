package com.inn.lambda;

import java.util.Objects;

public class Book {

	private Integer id;

	private String name;

	private Integer pages;

	public Book() {
		super();
	}

	public Book(Integer id, String name, Integer pages) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, pages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(pages, other.pages);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pages=" + pages + "]";
	}

}
