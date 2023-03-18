package com.sampleStore.InternetStore;

import com.sampleStore.InternetStore.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Article> getAll(){
     return jdbcTemplate.query("SELECT id, name, price, quantity FROM article",
                BeanPropertyRowMapper.newInstance(Article.class));
    }
}
