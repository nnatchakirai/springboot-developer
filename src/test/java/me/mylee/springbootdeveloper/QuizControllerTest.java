package me.mylee.springbootdeveloper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.sun.tools.classfile.Attribute.Code;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // 객체를 JSON 문자열로 변환해주는 API

    @DisplayName("GET /quiz?code=1 => 응답코드는 201, 응답 본문은 Created!를 리턴한다. " )
    @Test
    public void getQuiz1() throws Exception {
        // 준비 given
        final String url = "/quiz";

        // 실행 when
        final ResultActions result = mockMvc.perform(get(url).param("code", "1"));

        // 검증 them
        result.andExpect(status().isCreated()).andExpect(content().string("Created!"));
    }

    @DisplayName("POST /quiz 요청, 요청 바디에 {'value' :1}이면 응답 코드는 403, 응답 본문은 Forbidden!")
    @Test
    public void postQuiz1() throws Exception {
        // 준비 given
        final String url = "/quiz";

        // 실행 when
        final ResultActions result = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(new Code(1)))); // 이거 값이 value로 들어와야 함

        // 검증 them
        result.andExpect(status().isForbidden()).andExpect(content().string("Forbidden!"));
    }

    @DisplayName("POST /quiz 요청, 요청 바디에 {'Value': 2}이면 응답 코드는 200, 응답 본문은 OK!")
    @Test
    public void postQuiz2() throws Exception {
        // 준비 given
        final String url = "/quiz";

        // 실행 when
        final ResultActions result = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(new Code(2))));
        // 검증 them
        result.andExpect(status().isOk()).andExpect(content().string("OK!"));

    }
}