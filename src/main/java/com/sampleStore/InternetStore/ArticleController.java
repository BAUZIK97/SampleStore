package com.sampleStore.InternetStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("")
    public ResponseEntity<List<Article>> GetArticles(){
        return new ResponseEntity<>(articleRepository.getAll(), HttpStatus.OK); }

    @GetMapping("/{id}")
    public ResponseEntity<Article> GetArticleById(@PathVariable("id") int id){
        return new ResponseEntity<>(articleRepository.getById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody List<Article> articles){
        articleRepository.save(articles);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Article updatedArticle){
        Article articleToUpdate = articleRepository.getById(id);
        if(articleToUpdate != null) {
            articleRepository.fullUpdate(articleToUpdate,updatedArticle);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Article does not exist", HttpStatus.NOT_FOUND);
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<String> partialUpdate(@PathVariable("id") int id, @RequestBody Article updatedArticle){
        Article articleToUpdate = articleRepository.getById(id);
        if(articleToUpdate != null) {
            articleRepository.partialUpdate(articleToUpdate, updatedArticle);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Article does not exist", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        articleRepository.delete(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
