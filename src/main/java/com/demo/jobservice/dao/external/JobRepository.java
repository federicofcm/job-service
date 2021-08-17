package com.demo.jobservice.dao.external;

import com.demo.jobservice.controller.queryparameter.JobQueryParameters;
import com.demo.jobservice.exception.WebClientErrorException;
import com.demo.jobservice.model.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class JobRepository {

    @Value("${external.github-jobs.host}")
    private String HOST;

    @Value("${external.github-jobs.uri-scheme}")
    private String SCHEME;

    @Value("${external.github-jobs.path}")
    private String PATH;

    public List<Job> findByQPs(JobQueryParameters queryParameters) {

//        String url = UriComponentsBuilder.newInstance()
//                .scheme(SCHEME)
//                .host(HOST)
//                .path(PATH)
//                .queryParam("description", queryParameters.getDescription())
//                .build().toUriString();
//
//        log.info("GET: " + url);
        WebClient webclient = WebClient.builder()
                .baseUrl(HOST)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<List<Job>> response = webclient
                .get()
                .uri("/" + PATH)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Job>>() {})
                .onErrorMap(e -> new WebClientErrorException(e.getMessage()));

        List<Job> jobList = response.block();

        return jobList;
    }
}
