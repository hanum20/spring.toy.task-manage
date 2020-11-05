package com.oneum.toy.control;

import com.oneum.toy.domain.Account;
import com.oneum.toy.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@AllArgsConstructor
@Controller("/login")
public class AccountController {

    AccountService accountService;

    @GetMapping("signup")
    public String initSignUpForm(@ModelAttribute Account account){
        return "";
    }

}
