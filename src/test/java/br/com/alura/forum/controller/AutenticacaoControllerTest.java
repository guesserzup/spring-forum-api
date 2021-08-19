package br.com.alura.forum.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class AutenticacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnStatus400IfAuthenticationDataIsIncorrect() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"invalido@email.com\", \"senha\":\"123456\"}";

        mockMvc.perform(MockMvcRequestBuilders.post(uri).content(json).contentType(json)).andExpect(MockMvcResultMatchers.status().is(400));
    }

}