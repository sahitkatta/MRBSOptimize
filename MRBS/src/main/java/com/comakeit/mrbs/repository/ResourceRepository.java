package com.comakeit.mrbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comakeit.mrbs.entity.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

}
