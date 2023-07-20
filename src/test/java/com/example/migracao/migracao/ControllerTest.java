package com.example.migracao.migracao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
// @AutoConfigureWireMock(port = 0, stubs = "classpath:/mappings/*.json")
class ControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private UserService userService;

  @Autowired
  ObjectMapper mapper;

  @Test
  @DisplayName("Buscar usuario")
  void getUser() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print());

  }

  @Test
  void postUser() throws Exception {

    UserDTO request = new UserDTO();
    request.setNome("Otávio Pietro Porto");
    request.setCpf("54528256576");

    String body = mapper.writeValueAsString(request);

    mockMvc.perform(MockMvcRequestBuilders.post("/user")
        .contentType(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")
        .content(body))
        .andExpect(MockMvcResultMatchers.status().isCreated());
  }

  @Test
  void imprime() {

    int i = 2;
    i++;
    System.out.println("Teste");
    assertEquals(3, i);

  }
}
