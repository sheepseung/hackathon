package com.test.hackathon.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Phished {

    @Id
    @Column
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String url;

    public Phished() {
    }

    public Phished(Long id, String url) {
        this.id = id;
        this.url = url;
    }
}
