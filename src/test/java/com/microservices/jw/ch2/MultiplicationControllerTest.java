package com.microservices.jw.ch2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(MultiplicationController.class) // 특정 컨트롤러를 대상으로 하는 단위 테스트 웹 레이어에서 발생하는 요청과 응답을 테스트
// @SpringBootTest와 다른점은 웹 레이어의 Bean들만 로드 하므로 MVC를 위한 테스트라고 할 수 있다.
class MultiplicationControllerTest {

    // @Mock 대신 @MockBean을 사용한 이유는 진짜 Bean (MultiplicationServiceImpl) 대신 목객체를 주입
    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mockMvc;

    // 테스트 중에 객체를 Json으로 변환하거나 Json을 객체로 변환하기 위해 -> Json 직렬화/역직렬화
    private JacksonTester<Multiplication> json;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, ObjectMapper::new);
    }

    @Test
    void getRandomMultiplicationTest() throws Exception {
        // given
        given(multiplicationService.createRandomMultiplication()).willReturn(new Multiplication(70, 20));

        // when
        // 실제 HTTP응답을 처리해주는 것처럼 mock클래스를 사용하여 작성 할 수 있음
        MockHttpServletResponse response = mockMvc.perform(get("/multiplications/random")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        
        // JSON 객체로 반환 되는지 확인
        assertThat(response.getContentAsString())
                .isEqualTo(json.write(new Multiplication(70, 20)).getJson());

    }
}