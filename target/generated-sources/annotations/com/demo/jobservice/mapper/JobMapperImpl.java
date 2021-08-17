package com.demo.jobservice.mapper;

import com.demo.jobservice.dto.JobDto;
import com.demo.jobservice.model.Job;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-20T20:44:28-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.7 (Oracle Corporation)"
)
@Component
public class JobMapperImpl implements JobMapper {

    @Override
    public JobDto entityToDto(Job job) {
        if ( job == null ) {
            return null;
        }

        JobDto jobDto = new JobDto();

        if ( job.getId() != null ) {
            jobDto.setId( job.getId() );
        }
        if ( job.getType() != null ) {
            jobDto.setType( job.getType() );
        }
        if ( job.getCompany() != null ) {
            jobDto.setCompany( job.getCompany() );
        }
        if ( job.getLocation() != null ) {
            jobDto.setLocation( job.getLocation() );
        }
        if ( job.getTitle() != null ) {
            jobDto.setTitle( job.getTitle() );
        }
        if ( job.getDescription() != null ) {
            jobDto.setDescription( job.getDescription() );
        }

        return jobDto;
    }

    @Override
    public List<JobDto> entityToDtoList(List<Job> jobList) {
        if ( jobList == null ) {
            return null;
        }

        List<JobDto> list = new ArrayList<JobDto>( jobList.size() );
        for ( Job job : jobList ) {
            list.add( entityToDto( job ) );
        }

        return list;
    }
}
