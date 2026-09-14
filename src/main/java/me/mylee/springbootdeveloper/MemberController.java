package me.mylee.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    private final EnableSpringDataWebSupport.SpringDataWebConfigurationImportSelector springDataWebConfigurationImportSelector;
    private final ApplicationArguments springApplicationArguments;

    @Autowired
    private MemberService memberService;

    public MemberController(EnableSpringDataWebSupport.SpringDataWebConfigurationImportSelector springDataWebConfigurationImportSelector, ApplicationArguments springApplicationArguments) {
        this.springDataWebConfigurationImportSelector = springDataWebConfigurationImportSelector;
        this.springApplicationArguments = springApplicationArguments;
    }

    // 요청을 받아서 적절한 비즈니스 로직으로 연결
    // http://localhost:8080/member 요청과 메서드를 연결
    @GetMapping("/member")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();

    }
}
