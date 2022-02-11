package com.example.newsapiapp.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class NewsControllerTest {

    @Test
    void showRecordsWhenDataWasNotProvided() {
        // Given
        NewsController newsController = new NewsController();
        // When
        newsController.setResult(null);
        // Then
        Assertions.assertEquals("<h2 style=color:red>There is no data</h2>", newsController.showRecords());
    }

    @Test
    void showRecordsWhenSomeDataWasProvided() {
        // Given
        NewsController newsController = new NewsController();
        // When
        newsController.setResult(List.of("aaa"));
        // Then
        Assertions.assertEquals("aaa", newsController.showRecords());
    }



    @Test
    void getEverything() {
        // Given
        // When
        // Then
    }

    @Test
    void save() {
        // Given
        // When
        // Then
    }
}