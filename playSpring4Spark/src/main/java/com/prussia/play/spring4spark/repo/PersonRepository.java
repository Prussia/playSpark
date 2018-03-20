package com.prussia.play.spring4spark.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prussia.play.spring4spark.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
