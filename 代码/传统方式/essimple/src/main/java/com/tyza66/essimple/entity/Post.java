package com.tyza66.essimple.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// 示例文档类
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private String user;
    private String postDate;
    private String message;

    public Post(String user, String postDate, String message) {
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