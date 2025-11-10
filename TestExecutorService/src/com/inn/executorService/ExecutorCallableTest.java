package com.inn.executorService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableTest {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		// here submit method parameter type is callable
		Callable<Integer> callable1 = () -> 2 * 5;
		Callable<Integer> callable2 = () -> 3 * 2;
		Callable<Integer> callable3 = () -> 6 * 7;

		List<Callable<Integer>> callableList = Arrays.asList(callable1, callable2, callable3);
		// here invokeAll block main thread after completed executor service then main
		// thread will starts it's execution
		List<Future<Integer>> futures = executor.invokeAll(callableList);
		futures.forEach(future -> {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		executor.shutdown();
		System.out.println("main method...");
	}

}
