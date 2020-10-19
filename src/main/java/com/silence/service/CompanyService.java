package com.silence.service;

import com.silence.model.SuggestionsResponse;

public interface CompanyService {
    SuggestionsResponse findCompaniesSuggestions(String name);
}
