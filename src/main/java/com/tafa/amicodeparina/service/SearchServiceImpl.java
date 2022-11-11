package com.tafa.amicodeparina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tafa.amicodeparina.controllers.dto.SearchDto;
import com.tafa.amicodeparina.models.Search;
import com.tafa.amicodeparina.repository.SearchRepository;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchRepository searchRepository;

    @Override
    public Search save(SearchDto searchDto) {
        Search s = new Search(searchDto.getInput(), searchDto.getSearch(), searchDto.getDate(),
                searchDto.getResult(), searchDto.getUser());
        searchRepository.save(s);
        return s;
    }

    @Override
    public Search getSeachById(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
}