package com.dance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableTransactionManagement
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
//http://localhost:8197/ssafy-dance/swagger-ui.html