package me.mylee.springbootdeveloper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) {
        // 스프링 부트 실행
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}

/*
Web application (Web Service), Architecture : Client + Server,
Client : Request 보배는자 (Web Browser)
HTML, CSS(Bootstrap TailWind, ..), JavaScript(React, Vue, Angular, Next, Nuxt...)
Server : Request에 응답(Response) 하는 자
Spring Boot(Java) Framework 개념 동작 원리
24시간 365일 실행되어야 하는 프로그램
Web Server(WebSphere, Apache, WebLogic, Tomcat)
Process : 실행중인 프로그램
daemon process
port (포트)
status = 400 번대 오류는 클라이언트의 문제, 500번대는 서버의 문제
유지 관리가 쉽다. 기능별로 모듈화가 된다.
Backend : 클라이언트 요청 수신 분배, 비즈니스로 로직을 처리, view 생성 MVC(Model, View, Controller)

클라이언트 요청 처리를 하는법
1.Controller 클래스 생성(컨트롤러임을 스프링부트에게 알려줘야함)
   => 클래스 선언 위에 @RestController 사용
2.요청 URL (localhost:8080 뒤에 오는 path)과 이 요청을 처리 할 메서드를 매핑
   => 이 URL을 처리할 메서드 선언위에 @GetMapping 어노테이션 사용

클라이언트 요청방식
    1. Get         - 읽기
    2. Post        - 생성
    3. Patch(Put)  - 수정(부분, 전체)
    4. Delete      - 삭제

*/
