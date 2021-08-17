package com.demo.jobservice.mapper;

import com.demo.jobservice.dto.JobDto;
import com.demo.jobservice.model.Job;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        componentModel = "spring")
public interface JobMapper {

    JobMapper INSTANCE = Mappers.getMapper(JobMapper.class);

    JobDto entityToDto(Job job);
    List<JobDto> entityToDtoList(List<Job> jobList);

}
