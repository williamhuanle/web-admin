package mz.co.kr.webadmin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDto {
    private String accessToken;
    private String tokenType;
}
