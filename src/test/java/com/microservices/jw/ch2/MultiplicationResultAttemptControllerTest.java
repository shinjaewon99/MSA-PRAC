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

import static com.microservices.jw.ch2.MultiplicationResultAttemptController.ResultResponse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(MultiplicationController.class)
class MultiplicationResultAttemptControllerTest {

    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<MultiplicationResultAttempt> jsonResult;
    private JacksonTester<ResultResponse> jsonResponse;

    @BeforeEach
    void setUp() {
        JacksonTester.initFields(this, ObjectMapper::new);
    }

    @Test
    void postResultReturnCorrect() throws Exception {
        genericParameterizedTest(true);
    }

    @Test
    void postResultReturnNotCorrect() throws Exception {
        genericParameterizedTest(false);
    }

    void genericParameterizedTest(final boolean correct) throws Exception {
        // given
        given(multiplicationService.checkAttempt(any(MultiplicationResultAttempt.class)))
                .willReturn(true);

        User user = new User("jw");
        Multiplication multiplication = new Multiplication(50, 70);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500);

        // when
        MockHttpServletResponse response = mockMvc.perform(post("/results")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonResult.write(attempt).getJson()))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonResponse.write(new ResultResponse(correct)).getJson());
    }
}