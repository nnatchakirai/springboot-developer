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
spring boot: Controller, Service, Repository, View 등을 구현 해야함.
    백엔드는 클라이언트의 요청을받아서 비즈니스 로직을 수행하고, 그 결과를 클라이언트에게 전송.
Spring Boot 에서 요청을 받는 놈은 Controller 용도마다 다르게 만들어 놓을 수 있다.

클라이언트의 요청을 처리하는 로직을 백엔드에 구현하려고 한다면
Controller -> Service -> Repository(Entity 클래스 사용) 이기에 보통은 바텀 업 방식으로 구현함.
프레젠테이션계층   비즈니스계층    persistence(영속)계층(DB와 연동됨)

*Entity 클래스란 자바 클래스인데 DB테이블 생성 정보를 담고 있는 클래스


Repository는 자바의 interface로 구현.
자바의 interface의 특징은?
    -interface는 메서드 선언만 있고 구현은 이 인터페이스를
     implements 하는 클래스에서 구현함

public interface Person {
    public String getName();
    public integer getAge();
}

Person p = new Person(); X

public class Students implements Person{
    private String name;
    public String getName(){
        return this.name;
        }
}

Students = new Students();


등록된 회원 리스트를 반환하는 기능을 백엔드에 구현하려고 함
http://localhost:8080/test

DB에 회원정보가 등록되어 있어야 함.
회원정보가 등록되어 있으려면 DB테이블이 만들어져 있어야 한다.

패키지 이름은 항상 대문자로 시작

스프링 빈이란? 어노테이션이 붙은 애들

MVC(Moder View Controller)Design patton
Controller : 요청을 받아 비즈니스 로직을 수행하고 view 페이지 요청을 의롸
Model : data & logic
View : View 페이지 생성

CSR (Client Server' -React
SSR

*/
