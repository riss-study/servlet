package com.riss.hello.servlet;

import com.riss.hello.servlet.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ServletComponentScan	// 서블릿 자동 등록 (현재 패키지 기준 하위 패키지의 서블릿 등록)
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

	// application.yml 설정 파일에 ViewResolver 에 대한 prefix, suffix 를 넣으면 아래 코드를 스프링에서 자동으로 해줌
//	@Bean
//	ViewResolver internalResourceViewResolver () {
//		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//	}

    // @Component, @Controller 등의 어노테이션을 클래스 레벨에 붙이면 아래의 작업을 대신 해주는 역할을 한다.
//	@Bean
//	SpringMemberFormControllerV1 springMemberFormControllerV1 () {
//		return new SpringMemberFormControllerV1();
//	}
}
