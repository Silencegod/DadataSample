package com.silence.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silence.model.SuggestionsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {

    private static final Logger logger = LoggerFactory.getLogger(WriterServiceImpl.class);
    private final ObjectMapper jsonObjectMapper;

    public WriterServiceImpl(ObjectMapper jsonObjectMapper) {
        this.jsonObjectMapper = jsonObjectMapper;
    }

    @Override
    public File write(String pathname, SuggestionsResponse suggestionsResponse) {
        File resultFile = new File(pathname);
        try {
            jsonObjectMapper.writeValue(resultFile, suggestionsResponse);
        } catch (IOException e) {
            logger.error("Ошибка записи в файл", e);
        }
        return resultFile;
    }
}
