package mz.co.kr.webadmin.restclient;

import mz.co.kr.webadmin.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public UserDto getMe(String accessToken) {

        String urlGetMe = "http://localhost:8080/user/me";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity <> (headers);
        ResponseEntity<UserDto> response = restTemplate.exchange(urlGetMe, HttpMethod.GET, entity, UserDto.class);
        UserDto userDto = response.getBody();
        return userDto;
    }
}
