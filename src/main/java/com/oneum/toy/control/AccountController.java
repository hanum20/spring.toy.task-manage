package com.oneum.toy.control;

import com.oneum.toy.domain.Account;
import com.oneum.toy.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Account Controller
 */
@Slf4j
@Controller("/account")
public class AccountController {

    private static final String VIEWS_ACCOUNT_CREATE_OR_UPDATE = "account/signUpForm";
    private static final String VIEWS_LOGIN = "account/signUpForm";

    AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    // TODO : Configure View
    @GetMapping("signup")
    public String initSignUpForm(){
        return VIEWS_ACCOUNT_CREATE_OR_UPDATE;
    }

    /**
     * TODO :
     *  Validate
     *      * Invalid : 에러 메세지와 Sign Up Page로
     *      * Valid : Login Page로 Redirect
     *  Exception
     * @param account
     * @return
     */
    @PostMapping("signup")
    public String processSignUpForm(@ModelAttribute @Valid Account account){
        accountService.createAccount(account);
        return "redirect:/account/signin";
    }

    @GetMapping("siginin")
    public String initSignInForm() {
        return VIEWS_LOGIN;
    }

    @PostMapping("siginin")
    public String processSignInForm(@ModelAttribute Account account) {
        return "redirect:/index";
    }

}
