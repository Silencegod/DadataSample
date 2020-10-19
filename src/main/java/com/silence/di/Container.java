package com.silence.di;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.silence.repository.DadataClient;
import com.silence.service.CompanyService;
import com.silence.service.CompanyServiceImpl;
import com.silence.service.WriterService;
import com.silence.service.WriterServiceImpl;
import com.squareup.okhttp.OkHttpClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Container {
    private static Container instance;

    private final ObjectMapper jsonObjectMapper;
    private final CompanyService companyService;
    private final WriterService writerService;


    private Container() {
        this.jsonObjectMapper = new JsonMapper();
        configureJsonMapper();
        OkHttpClient okHttpClient = new OkHttpClient();
        DadataClient dadataClient = new DadataClient(okHttpClient, jsonObjectMapper);
        this.companyService = new CompanyServiceImpl(dadataClient);
        this.writerService = new WriterServiceImpl(jsonObjectMapper);
    }

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public WriterService getWriterService() {
        return writerService;
    }

    private void configureJsonMapper() {
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        this.jsonObjectMapper.registerModule(timeModule);
    }
}
