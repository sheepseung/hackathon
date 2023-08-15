package com.test.hackathon.controller;


import com.test.hackathon.entity.NotSure;
import com.test.hackathon.entity.Phished;
import com.test.hackathon.entity.Result;
import com.test.hackathon.entity.Verified;
import com.test.hackathon.repository.NotSureRepository;
import com.test.hackathon.repository.PhishedRepository;
import com.test.hackathon.repository.VerifiedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
public class ResultController {

    private final NotSureRepository notSureRepository;
    private final PhishedRepository phishedRepository;
    private final VerifiedRepository verifiedRepository;


    @GetMapping("get")
    public Result getResult(@RequestParam("url") String url) {
        Optional<NotSure> notSureUrl = notSureRepository.findByUrl(url);
        Optional<Phished> phishedUrl = phishedRepository.findByUrl(url);
        Optional<Verified> verifiedUrl = verifiedRepository.findByUrl(url);

        boolean isSafe = true;
        boolean isDangerous = true;
        int reportCount = 0;

        if (verifiedUrl.isEmpty()){
            isSafe = false;
        }

        if(phishedUrl.isEmpty()){
            isDangerous = false;
        }

        if(!notSureUrl.isEmpty()){
            reportCount = notSureUrl.get().getReportCount();
        }

        Result result = Result.builder()
                .isSafe(isSafe)
                .isDangerous(isDangerous)
                .reportCount(reportCount)
                .url(url)
                .build();

        return result;
    }


}
