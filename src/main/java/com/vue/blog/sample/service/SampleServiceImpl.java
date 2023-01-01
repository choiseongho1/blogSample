package com.vue.blog.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.blog.sample.domain.Sample;
import com.vue.blog.sample.dto.SampleDto;
import com.vue.blog.sample.repository.SampleRepository;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    SampleRepository sampleRepository;

    @Override
    public List<Sample> list() {
        return sampleRepository.findAll();
    }

    @Override
    public SampleDto getSample(Long id) {
        Sample sample = sampleRepository.findById(id).get();

        SampleDto sampleDto = SampleDto.builder()
                .id(sample.getId())
                .name(sample.getName())
                .build();

        return sampleDto;
    }

    @Override
    public Sample saveSample(SampleDto sampleDto) {

        return sampleRepository.save(sampleDto.toEntity());
    }

    @Override
    public void deleteSample(Long id) {
        sampleRepository.delete(sampleRepository.findById(id).get());
    }
}
