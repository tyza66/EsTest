package com.tyza66.essimple.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

// 示例文档类
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Post {
    private String user;
    private String postDate;
    private String message;

    @JsonCreator
    public Post(@JsonProperty("user") String user,
                @JsonProperty("postDate") String postDate,
                @JsonProperty("message") String message) {
        this.user = user;
        this.postDate = postDate;
        this.message = message;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Post{" +
                "user='" + user + '\'' +
                ", postDate='" + postDate + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}