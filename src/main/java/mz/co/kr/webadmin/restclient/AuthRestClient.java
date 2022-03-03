package mz.co.kr.webadmin.restclient;

import mz.co.kr.webadmin.dto.AuthDto;
import mz.co.kr.webadmin.dto.SignInDto;
import mz.co.kr.webadmin.dto.SignUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthRestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value( "${restclient.auth-service.loginUrl}")
    private String urlLogin;

    @Value( "${restclient.auth-service.signupUrl}")
    private String urlSignup;

    public AuthDto login(SignInDto signInDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SignInDto> request = new HttpEntity<>(signInDto, headers);
        ResponseEntity<AuthDto> response = restTemplate
                .exchange(urlLogin, HttpMethod.POST, request, AuthDto.class);
        AuthDto authDto = response.getBody();
        return authDto;
    }

    public void signup(SignUpDto signUpDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SignUpDto> request = new HttpEntity<>(signUpDto, headers);
        restTemplate.exchange(urlSignup, HttpMethod.POST, request, AuthDto.class);
    }
}
