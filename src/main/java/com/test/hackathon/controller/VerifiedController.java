package com.test.hackathon.controller;

import com.test.hackathon.entity.Verified;
import com.test.hackathon.repository.VerifiedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/verified")
@RequiredArgsConstructor
public class VerifiedController {

    private final VerifiedRepository verifiedRepository;


    @GetMapping("list")
    public List<Verified> findAll() {
        return (List<Verified>) verifiedRepository.findAll();
    }

    @GetMapping("find")
    public Optional<Verified> findByUrl(@RequestParam("url") String url) {
        return verifiedRepository.findByUrl(url);
    }

}
