package me.mylee.springbootdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {
    // 요청 URL과 요청 방식(GET, POST, PATCH PUT DELETE)에 따라 그 요청을 실행할 메서드를 매핑

    @GetMapping("/quiz")
    public ResponseEntity<String> quiz(@RequestParam("code") int code){
        switch (code){
            case 1:
                return ResponseEntity.created(null).body("Created!"); //201, "Created!"
            case 2:
                return ResponseEntity.badRequest().body("Bad Request!"); // 400, "Bad Request!"
            default:
                return ResponseEntity.ok().body("OK!"); // 200, "OK!"
        }
    }

    @PostMapping("/quiz")
    public ResponseEntity<String> quizz(@RequestBody Integer code) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~["+code+"]");
        switch (code) {
            case 1:
                return ResponseEntity.status(403).body("Forbidden!"); // .status를 통해 번호를 지정 해 줄 수 있음
            default:
                return ResponseEntity.ok().body("OK!");
        }
    }
}


