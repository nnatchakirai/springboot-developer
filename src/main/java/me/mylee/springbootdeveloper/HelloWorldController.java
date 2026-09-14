package me.mylee.springbootdeveloper;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    // '/hello' 요청을 보내면 hello()매서드 호출
    // https://localhost:8080/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

//    @GetMapping("/test")
//    public String test() {
//        return "Hello Everyone!!!!!";
//    }
    // http://localhost:8080/test -> "Hello Everyone!!"

    @PostMapping("/test")
    public String postTest() {
        return "Post Test Response!!!!!!";
    }

    @DeleteMapping("/test")
    public String deleteTest(){
        return "Delete Test Response!!!!!!";
    }

    @PutMapping("/test")
    public String putTest(){
        return "Put Test Response!!!!!!";
    }
}


//이렇게 사용하면 웹에서 /test를 했을때 구분이 안된다. 그렇기 때문에 Postman을 사용해 잘 구현이 되었나 확인함

