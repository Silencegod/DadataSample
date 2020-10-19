package com.silence.service;

import com.silence.model.SuggestionsResponse;

import java.io.File;

public interface WriterService {
    File write(String pathname, SuggestionsResponse suggestionsResponse);
}
