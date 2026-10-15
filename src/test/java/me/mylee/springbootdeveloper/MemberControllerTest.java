package me.mylee.springbootdeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // 직접 내가 인터넷에 HTTP를 보내고 할 필요 없이 자동으로 해주는 어노테이션
class MemberControllerTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void deleteAll() {
        memberRepository.deleteAll();
    }

    @Test
    void getAllMembers() throws Exception {
        // 준비 (given)
        // 한 명의 화원을 DB테이블에 저장함으로써 등록
        final String url = "/member";
        Member savedMember = memberRepository.save(new Member("이민영"));// 내부적으로 INSERT INTO(key가 없을 때) or UPDATE(key가 있을 때) 수행함

        // 실행 (when)
        // 회원 리스트 요청
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));


        // 검증 (then)
        // 회원 리스트 요청에 의해서 전달받은 데이터가 준비 단계에서 저장된 회원 정보와 동일한지 결정
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }
}