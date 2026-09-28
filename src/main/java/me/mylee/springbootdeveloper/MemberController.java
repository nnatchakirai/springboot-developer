package me.mylee.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RequestMapping("/api/members")
@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    // 요청을 받아서 적절한 비즈니스 로직으로     연결
    // http://localhost:8080/member 요청과 메서드를 연결
    @GetMapping("/member")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();

    }
    // 회원정보를 등록하는 요청
    // http://localhost:8080/member 요청을 POST 방식으로 했을 때 회원 등록을 처리하도록 구성
    @PostMapping("/member")
    public ResponseEntity<Member> createMember(@RequestBody Member member) { // 내부 데이터는 responseentity에 넣지 않는다.
        // 비즈니스 로직을 호출
        // return ResponseEntity.ok(memberService.saveMember(member));
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.saveMember(member));
    }
}
