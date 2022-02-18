package mz.co.kr.webadmin.services;

import mz.co.kr.webadmin.dto.AuthDto;
import mz.co.kr.webadmin.dto.SignInDto;
import mz.co.kr.webadmin.dto.SignUpDto;
import mz.co.kr.webadmin.dto.UserDto;
import mz.co.kr.webadmin.restclient.AuthRestClient;
import mz.co.kr.webadmin.restclient.UserRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRestClient userRestClient;

    @Autowired
    private AuthRestClient authRestClient;

    public UserDto getMe(String accessToken) {
        return userRestClient.getMe(accessToken);
    }

    public void signUp(SignUpDto signUpDto) {
        authRestClient.signup(signUpDto);
    }

    public AuthDto login(SignInDto signInDto) {
        return authRestClient.login(signInDto);
    }

}
