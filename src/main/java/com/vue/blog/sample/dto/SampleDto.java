package com.vue.blog.sample.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.vue.blog.sample.domain.Sample;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SampleDto {
    private Long id;
    private String name;

    @QueryProjection
    public SampleDto(
            Long id,
            String name) {
        this.id = id;
        this.name = name;
    }

    public Sample toEntity() {
        return Sample.builder()
                .name(name)
                .build();
    }
}
