package com.inn.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorRunnableTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(4);
		//PARAMETER OF SUBMIT METHOD IS Runnable
		executor.submit(() -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println(factorial(i));
			}
		});
		executor.shutdown();
		try {
			executor.awaitTermination(1000, TimeUnit.NANOSECONDS);
			System.out.println("total execution time in nanoseconds = " + (System.currentTimeMillis() - startTime));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static Integer factorial(int num) {
		int result = 1;
		for (int i = 1; i <= num; i++) {
			result = result * i;
		}
		return result;
	}

}
