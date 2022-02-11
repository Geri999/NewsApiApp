package com.example.newsapiapp.controller;

import com.example.newsapiapp.model.Response;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
@Data
@RestController
public class NewsController {

    private String category = "business";
    private String country = "pl";
    @Value("${api-key}")
    private String apiKey;
    private List<String> result;

//    @Autowired
//    private RestTemplate restTemplate;


    @GetMapping(path = "/printnews")
    public String showRecords() {
        if (result == null) return "<h2 style=color:red>There is no data</h2>";

        return result.stream().collect(Collectors.joining("\n"));
    }

    @GetMapping(path = "/getnews")
    public String getEverything() {

        String url = String.format("https://newsapi.org/v2/top-headlines?apiKey=%s&category=%s&country=%s", apiKey, category, country);

        RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(url, Response.class);

        result = response
                .getArticles()
                .stream()
                .map(o -> o.getTitle() + ":" + o.getDescription() + ":" + o.getAuthor())
                .collect(Collectors.toList());
        return "<h2>Data obtained successfully</h2>";
    }

    @GetMapping(path = "/save")
    public String save() {
        if (result == null) {
            return "<h2 style=color:red>There is no data</h2>";
        }

        File fileName = new File("result.txt");
        try {
            FileOutputStream fos = new FileOutputStream(fileName, false);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bufferedWriter = new BufferedWriter(osw);
            bufferedWriter.write(result.stream().collect(Collectors.joining("\n")));
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "<h2 style=color:green>Data saved</h2>";
    }
}