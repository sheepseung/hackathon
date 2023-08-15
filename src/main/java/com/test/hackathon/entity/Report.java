package com.test.hackathon.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String url;

    @Column
    private String reportBody;

    public Report() {
    }

    public Report(Long id, String url, String reportBody) {
        this.id = id;
        this.url = url;
        this.reportBody = reportBody;
    }
}
