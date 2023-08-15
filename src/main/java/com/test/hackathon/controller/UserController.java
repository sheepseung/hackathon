package com.test.hackathon.controller;

import com.test.hackathon.entity.User;
import com.test.hackathon.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/join")
    public String signUp(@RequestParam("email") String email, @RequestParam("passWord") String passWord) {
        Optional<User> findUser = userRepository.findByEmail(email);
        if (!findUser.isEmpty()) {
            return "이미 사용 중인 아이디입니다.";
        } else {
            User joinUser = new User(email, passWord);
            userRepository.save(joinUser);
            return "회원가입이 성공적으로 완료되었습니다.";
        }
    }

    @PostMapping("/login")
    public String signIn(@RequestParam("email") String email, @RequestParam("passWord") String passWord){
        Optional<User> loginUser = userRepository.findByEmail(email);
        if(loginUser.isPresent() && loginUser.get().getPassWord().equals(passWord))
            return "성공";
        else
            return "실패";
    }
}
