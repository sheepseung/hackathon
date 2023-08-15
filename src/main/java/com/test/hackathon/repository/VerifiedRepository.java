package com.test.hackathon.repository;

import com.test.hackathon.entity.Verified;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VerifiedRepository extends CrudRepository<Verified, Long> {
    Optional<Verified> findByUrl(String url);

}
