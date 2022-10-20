package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/* 사용의미 찾아보기
@ComponentScan("com.example.demo")
@MapperScan("com.example.demo.mapper")  // Mapper.java 클래스들에 @Mapper 전부 쓰지 않을 경우 작성
*/
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}




}
