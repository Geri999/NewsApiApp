package com.example.newsapiapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Response {

    private String status;
    private int totalResults;
    private List<Article> articles;
}