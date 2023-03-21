package com.sampleStore.InternetStore;

import org.jetbrains.annotations.NotNull;
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
    public Article getById(int id){
        return jdbcTemplate.queryForObject("SELECT id, name, price, quantity FROM article WHERE id = ?",
                BeanPropertyRowMapper.newInstance(Article.class),id);
    }

    public int save(@NotNull List<Article> articles) {
        articles.forEach( article -> jdbcTemplate.update("INSERT INTO article(name, price, quantity)" +
                        " VALUES (?,?,?) ", article.getName(), article.getPrice(), article.getQuantity() ));

        return 1;
    }

    private int update(@NotNull Article article) {
        jdbcTemplate.update("UPDATE article SET name=?, price=?, quantity=? WHERE id=?",article.getName(),
                article.getPrice(), article.getQuantity(), article.getId() );

        return 1;
    }

    public int fullUpdate(@NotNull Article articleToUpdate, @NotNull Article updatedArticle) {
        articleToUpdate.setName(updatedArticle.getName());
        articleToUpdate.setPrice(updatedArticle.getPrice());
        articleToUpdate.setQuantity(updatedArticle.getQuantity());
        update(articleToUpdate);
        return 1;
    }
    public int partialUpdate(Article articleToUpdate, @NotNull Article updatedArticle) {
        if (updatedArticle.getName() != null) articleToUpdate.setName(updatedArticle.getName());
        if (updatedArticle.getPrice() > 0) articleToUpdate.setPrice(updatedArticle.getPrice());
        if (updatedArticle.getQuantity() > 0) articleToUpdate.setQuantity(updatedArticle.getQuantity());
        update(articleToUpdate);
        return 1;
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM article WHERE id=?", id);
    }
}
