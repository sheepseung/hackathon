package com.test.hackathon.controller;

import com.test.hackathon.entity.NotSure;
import com.test.hackathon.entity.Report;
import com.test.hackathon.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportRepository reportRepository;


    @GetMapping("list")
    public List<Report> findAll() {
        return (List<Report>) reportRepository.findAll();
    }

    @GetMapping("find")
    public Optional<Report> findByUrl(@RequestParam("url") String url) {
        return reportRepository.findByUrl(url);
    }

    @PostMapping("new")
    public Report createUrl(@RequestParam("url") String url, @RequestParam("report_body") String reportBody) {
        Report report = Report.builder()
                .url(url)
                .reportBody(reportBody)
                .build();

        reportRepository.save(report);
        return report;
    }
}
