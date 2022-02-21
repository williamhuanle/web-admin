package mz.co.kr.webadmin.controller;

import mz.co.kr.webadmin.dto.AuthDto;
import mz.co.kr.webadmin.dto.SignInDto;
import mz.co.kr.webadmin.dto.SignUpDto;
import mz.co.kr.webadmin.dto.UserDto;
import mz.co.kr.webadmin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new SignInDto());
        return "login";
    }

    @PostMapping("/login")
    public RedirectView doLogin(@ModelAttribute("user") SignInDto signInDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/", true);
        // call api login
        AuthDto authenticated = userService.login(signInDto);
        System.out.println("access token is : " + authenticated.getAccessToken());
        //
        redirectAttributes.addFlashAttribute("user", signInDto);
        redirectAttributes.addFlashAttribute("isLogged", true);
        redirectAttributes.addFlashAttribute("isNormal", true);
        return redirectView;
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new SignUpDto());
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView signup(@ModelAttribute("user") SignUpDto signUpDto, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/", true);
        // call api signup
        userService.signUp(signUpDto);
        //
        redirectAttributes.addFlashAttribute("user", signUpDto);
        redirectAttributes.addFlashAttribute("isLogged", false);
        redirectAttributes.addFlashAttribute("isRegistered", true);
        return redirectView;
    }

    @GetMapping("/oauth2/redirect")
    public RedirectView oauth2(@RequestParam(required = false) String token, @RequestParam(required = false) String error, RedirectAttributes redirectAttributes) {
        if(!StringUtils.isEmpty(token)) {
            final RedirectView redirectView = new RedirectView("/", true);
            UserDto userDto = userService.getMe(token);
            redirectAttributes.addFlashAttribute("isLogged", true);
            redirectAttributes.addFlashAttribute("isOauth2", true);
            redirectAttributes.addFlashAttribute("user", userDto);
            return redirectView;
        } else {
            return new RedirectView("/login");
        }
    }
}
