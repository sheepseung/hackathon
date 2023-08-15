package com.test.hackathon.controller;

import com.test.hackathon.entity.Phished;
import com.test.hackathon.repository.PhishedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/phished")
@RequiredArgsConstructor
public class PhishedController {

    private final PhishedRepository phishedRepository;


    @GetMapping("list")
    public List<Phished> findAll() {
        return (List<Phished>) phishedRepository.findAll();
    }

    @GetMapping("find")
    public Optional<Phished> findByUrl(@RequestParam("url") String url) {
        return phishedRepository.findByUrl(url);
    }

}
