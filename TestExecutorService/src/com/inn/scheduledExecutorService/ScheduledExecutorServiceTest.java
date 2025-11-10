package com.inn.scheduledExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
		// this task is executed after 5 seconds of delay
		ScheduledFuture<Integer> schedulerResponse = scheduled.schedule(() -> 5 * 3, 5, TimeUnit.SECONDS);
		System.out.println(schedulerResponse.get());
		scheduled.shutdown();
		System.out.println("main thread...");
	}

}
