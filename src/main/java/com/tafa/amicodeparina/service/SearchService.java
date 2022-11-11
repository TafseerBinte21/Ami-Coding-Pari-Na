package com.tafa.amicodeparina.service;

import com.tafa.amicodeparina.models.Search;
import com.tafa.amicodeparina.controllers.dto.SearchDto;

public interface SearchService {
    Search save(SearchDto searchDto);

    Search getSeachById(Long id) throws Exception;
}
