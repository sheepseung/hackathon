package com.test.hackathon.repository;

import com.test.hackathon.entity.NotSure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NotSureRepository extends CrudRepository<NotSure, Long> {
    Optional<NotSure> findByUrl(String url);

}
