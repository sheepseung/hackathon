package com.test.hackathon.repository;

import com.test.hackathon.entity.Phished;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhishedRepository extends CrudRepository<Phished, Long> {
    Optional<Phished> findByUrl(String url);
}
