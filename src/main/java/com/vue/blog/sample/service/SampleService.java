package com.vue.blog.sample.service;

import java.util.List;

import com.vue.blog.sample.domain.Sample;
import com.vue.blog.sample.dto.SampleDto;

public interface SampleService {
    public List<Sample> list();

    public SampleDto getSample(Long id);

    public Sample saveSample(SampleDto sampleDto);

    public void deleteSample(Long id);

}
