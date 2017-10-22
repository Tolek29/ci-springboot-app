package org.gm.user.controller;


import org.assertj.core.api.Assertions;
import org.gm.user.domain.AppUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@TestPropertySource(locations = "classpath:application-test.yml")
public class HomeControllerIntegrationTests {

  RestTemplate restTemplate = new RestTemplate();

  @Test
  public void shouldAddAppUserToDb() {

    ResponseEntity<AppUser> responseEntity = restTemplate
      .postForEntity("http://localhost:8090/user/Tolek",
        MockHttpServletRequest.DEFAULT_PROTOCOL,
        AppUser.class);

    final AppUser appUser = responseEntity.getBody();

    Assertions.assertThat(appUser).isNotNull();
    Assertions.assertThat(appUser.getUsername()).isNotNull().isEqualTo("Tolek");
  }
}
