package com.sampleStore.InternetStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class OrderController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("/test")
    public int test(){
        return 1;
    }

    @GetMapping("/articles")
    public List<Article> GetArticles(){
        return articleRepository.getAll();
    }
}
