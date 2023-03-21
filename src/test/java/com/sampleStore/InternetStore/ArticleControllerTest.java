package com.sampleStore.InternetStore;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ArticleControllerTest {

    private ArticleRepository createMock(){
        List<Article> EmptyList = new ArrayList<Article>();
        ArticleRepository mock = Mockito.mock(ArticleRepository.class);
        Mockito.when(mock.getAll()).thenReturn(EmptyList);
        return mock;
    }
    @Test
    void getAllArticles() {

        ArticleRepository mock = createMock();
        ArticleController controller = new ArticleController();


        var response = controller.GetArticles();
        mock.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getArticleById() {
    }

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void partialUpdate() {
    }

    @Test
    void delete() {
    }
}