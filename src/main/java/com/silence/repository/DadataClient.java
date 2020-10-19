package com.silence.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silence.model.SuggestionsRequestBody;
import com.silence.model.SuggestionsResponse;
import com.squareup.okhttp.*;

import java.io.IOException;

public class DadataClient {

    private final OkHttpClient client;
    private final ObjectMapper jsonObjectMapper;
    private final MediaType mediaType = MediaType.parse("application/json");
    private final String DADATA_URL = "https://suggestions.dadata.ru";
    private final String AUTH_TOKEN = "Token afb96b6cd31d0961aff5d986fe534347af414bc4";

    public DadataClient(OkHttpClient client, ObjectMapper jsonObjectMapper) {
        this.client = client;
        this.jsonObjectMapper = jsonObjectMapper;
    }

    public SuggestionsResponse postSuggest(SuggestionsRequestBody suggestionsRequestBody) throws IOException {
        RequestBody body = RequestBody.create(mediaType, jsonObjectMapper.writeValueAsString(suggestionsRequestBody));
        Request request = new Request.Builder()
                .url(DADATA_URL + "/suggestions/api/4_1/rs/suggest/party")
                .method("POST", body)
                .addHeader("Authorization", AUTH_TOKEN)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected status code: " + response.code());
        return jsonObjectMapper.readValue(response.body().string(), SuggestionsResponse.class);
    }
}
