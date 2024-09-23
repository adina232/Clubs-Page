package com.adn.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

//	@Bean
//	public CommandLineRunner run(ApplicationContext context) {
//		return args -> {
//			var beans = context.getBeanDefinitionNames();
//			Arrays.stream(beans).sorted().forEach(System.out::println);
//		};
//	}

}
