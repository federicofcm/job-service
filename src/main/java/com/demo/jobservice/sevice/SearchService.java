package com.demo.jobservice.sevice;

import com.demo.jobservice.dao.SearchRepository;
import com.demo.jobservice.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final SearchRepository searchRepository;

    @Autowired
    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Search> findAll() {
        return searchRepository.findAll();
    }
}
