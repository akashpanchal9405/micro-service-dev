package com.inn.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionTest {

	public static List<Book> getBooks() {
		return Arrays.asList(new Book(45, "Core Java", 400), new Book(32, "Advanced Java", 500),
				new Book(73, "Spring", 600), new Book(12, "Hibernate", 600));
	}

	public static void main(String[] args) {
		List<Book> bookList = getBooks();
//		Collections.sort(bookList, new MyComparator());
//		Collections.sort(bookList, (o1, o2) -> o1.getName().compareTo(o2.getName()));// Asc order
		Collections.sort(bookList, (o1, o2) -> o2.getName().compareTo(o1.getName()));//desc order
		System.out.println(bookList);
	}

}

//this is traditional approach before lambda expression
/*
 * class MyComparator implements Comparator<Book> {
 * 
 * // sort based on book name by custom sorting using comparator
 * 
 * @Override public int compare(Book o1, Book o2) { // return
 * o1.getName().compareTo(o2.getName());// Ascending order return
 * o2.getName().compareTo(o1.getName());// Descending order }
 * 
 * }
 */
