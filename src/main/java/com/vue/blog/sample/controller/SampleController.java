package com.vue.blog.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vue.blog.sample.domain.Sample;
import com.vue.blog.sample.dto.SampleDto;
import com.vue.blog.sample.service.SampleService;

@RestController
public class SampleController {

    @Autowired
    SampleService sampleService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sample/list.do")
    public List<Sample> home() {
        return sampleService.list();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/sample/{id}")
    public SampleDto getBoard(@PathVariable String id) {
        return sampleService.getSample(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/sample")
    public Sample create(@RequestBody SampleDto sampleDto) {
        return sampleService.saveSample(sampleDto);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/sample/{id}")
    public void delete(@PathVariable String id) {
        sampleService.deleteSample(id);
    }
}
