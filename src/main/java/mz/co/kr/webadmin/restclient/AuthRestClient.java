package mz.co.kr.webadmin.restclient;

import mz.co.kr.webadmin.dto.AuthDto;
import mz.co.kr.webadmin.dto.SignInDto;
import mz.co.kr.webadmin.dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public AuthDto login(SignInDto signInDto) {

        String urlLogin = "http://localhost:8080/auth/login";

        HttpEntity<SignInDto> request = new HttpEntity<>(signInDto);
        ResponseEntity<AuthDto> response = restTemplate
                .exchange(urlLogin, HttpMethod.POST, request, AuthDto.class);
        AuthDto authDto = response.getBody();
        return authDto;
    }

    public void signup(SignUpDto signUpDto) {

        String urlSignup = "http://localhost:8080/auth/signup";

        HttpEntity<SignUpDto> request = new HttpEntity<>(signUpDto);
        restTemplate.exchange(urlSignup, HttpMethod.POST, request, AuthDto.class);
    }
}
