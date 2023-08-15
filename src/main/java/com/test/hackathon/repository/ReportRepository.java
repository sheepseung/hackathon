package com.test.hackathon.repository;

import com.test.hackathon.entity.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReportRepository extends CrudRepository<Report, Long> {
    Optional<Report> findByUrl(String url);
}
