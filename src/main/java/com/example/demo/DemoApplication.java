package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@SpringBootApplication
@Configuration
@EnableAsync
public class DemoApplication implements AsyncConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		(new SimpleThread()).start();
//		(new TimeSort()).sort();
	}
}
