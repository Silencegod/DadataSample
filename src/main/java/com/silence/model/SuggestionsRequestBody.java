package com.silence.model;

import java.util.List;

public class SuggestionsRequestBody {
    private String query;
    private List<String> status;
    private int count;

    public SuggestionsRequestBody(String query, List<String> status, int count) {
        this.query = query;
        this.status = status;
        this.count = count;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
