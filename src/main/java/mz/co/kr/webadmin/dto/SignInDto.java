package mz.co.kr.webadmin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String password;
}
