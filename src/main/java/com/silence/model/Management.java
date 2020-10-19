package com.silence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "name",
        "post",
        "disqualified"
})
public class Management {

    @JsonProperty("name")
    private String name;
    @JsonProperty("post")
    private String post;
    @JsonProperty("disqualified")
    private Object disqualified;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("post")
    public String getPost() {
        return post;
    }

    @JsonProperty("post")
    public void setPost(String post) {
        this.post = post;
    }

    @JsonProperty("disqualified")
    public Object getDisqualified() {
        return disqualified;
    }

    @JsonProperty("disqualified")
    public void setDisqualified(Object disqualified) {
        this.disqualified = disqualified;
    }

}
