package com.silence.service;

import com.silence.model.Suggestion;
import com.silence.model.SuggestionsRequestBody;
import com.silence.model.SuggestionsResponse;
import com.silence.repository.DadataClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyServiceImpl implements CompanyService {

    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);
    private static final List<String> status = Collections.singletonList("ACTIVE");
    private static final int COUNT = 20;
    private final DadataClient dadataClient;

    public CompanyServiceImpl(DadataClient dadataClient) {
        this.dadataClient = dadataClient;
    }

    @Override
    public SuggestionsResponse findCompaniesSuggestions(String query) {
        SuggestionsRequestBody requestBody = new SuggestionsRequestBody(query, status, COUNT);
        SuggestionsResponse response = null;
        try {
            response = dadataClient.postSuggest(requestBody);
        } catch (IOException e) {
            logger.error("Не удалось выполнить запрос", e);
        }
        if (response != null) {
            sortByRegistrationDate(response);
        }
        return response;
    }

    private void sortByRegistrationDate(SuggestionsResponse suggestionsResponse) {
        List<Suggestion> filtered = suggestionsResponse.getSuggestions()
                .stream()
                .sorted((Comparator.comparing(o -> o.getData().getState().getRegistrationDate())))
                .collect(Collectors.toList());
        suggestionsResponse.setSuggestions(filtered);
    }
}
