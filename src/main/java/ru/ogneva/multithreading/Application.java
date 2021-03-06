package ru.ogneva.multithreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Configuration
@EnableAsync
public class Application implements AsyncConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		(new SimpleThread()).start();
//		(new TimeSort()).sort();
	}
}
