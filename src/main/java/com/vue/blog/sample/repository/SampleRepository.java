package com.vue.blog.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vue.blog.sample.domain.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {

}
