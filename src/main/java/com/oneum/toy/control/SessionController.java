package com.oneum.toy.control;

import com.oneum.toy.config.JwtTokenProvider;
import com.oneum.toy.domain.Account;
import com.oneum.toy.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
public class SessionController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private AccountRepository accountRepository;

    @GetMapping("/account")
    public String info(@RequestBody Map<String, String> account){
        return account.toString();
    }

    @PostMapping("/signup")
    public Long signup(@RequestBody Map<String, String> account){
        return accountRepository.save(
                Account.builder()
                    .username(account.get("username"))
                    .password(passwordEncoder.encode(account.get("password")))
                    .build()
        ).getId();
    }

    // 로그인
    @PostMapping("/signin")
    public String login(@RequestBody Map<String, String> account) {
        Account member = accountRepository.findByUsername(account.get("username"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 사용자 입니다."));
        if (!passwordEncoder.matches(account.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


}
