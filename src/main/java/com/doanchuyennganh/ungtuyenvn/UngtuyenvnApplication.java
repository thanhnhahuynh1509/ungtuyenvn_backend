package com.doanchuyennganh.ungtuyenvn;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class UngtuyenvnApplication {

	public static void main(String[] args) {
		SpringApplication.run(UngtuyenvnApplication.class, args);
		System.out.println(new File("").getAbsolutePath());
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
