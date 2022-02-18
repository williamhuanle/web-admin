package mz.co.kr.webadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/")
    public String getHelloMessage(ModelAndView model) {
        model.addObject("message", "Guys!");
        return "index";
    }
}
