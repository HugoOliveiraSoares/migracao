package com.example.migracao.migracao;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLException;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private UserDataRepository userDataRepository;

  @Value("${fact.url}")
  String url;

  public UserData getUser(Long id) throws SQLException {
    Optional<UserData> byId = userDataRepository.findById(id);
    if (byId.isEmpty()) {
      throw new SearchExecption("Usuario não encontrado");
    }
    return byId.get();
  }

  @Transactional
  public UserData registerUser(UserDTO userDto) {
    UserData convert = userDto.convert();
    RestTemplate restTemplate = new RestTemplate();

    try {
      ResponseFact responseFact = restTemplate.getForObject(url, ResponseFact.class);
      convert.setFact(responseFact.getText());
    } catch (HttpClientErrorException | HttpServerErrorException exception) {
      throw new APIException(exception.getMessage());
    }
    return userDataRepository.save(convert);
  }

}
