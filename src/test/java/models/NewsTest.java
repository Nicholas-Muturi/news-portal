package models;

import dao.DatabaseRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ConstantConditions")
public class NewsTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private News simpleNews(){
        return new News("Simple News","Nothing to report");
    }

    private News altNews(){
        return new News("New Album","Kanye drop new album","Entertainment");
    }

    @Test
    public void intializeCorrectly(){
        News news = altNews();
        assertTrue(news instanceof News);
    }

    @Test
    public void getFunctionsWorkCorrectly(){
        News news = simpleNews();
        assertEquals(news.getTitle(),simpleNews().getTitle());
        assertEquals(news.getDescription(),simpleNews().getDescription());
        assertEquals(news.getType(),simpleNews().getType());
    }

    @Test
    public void getDifferentNewsType(){
        News news = simpleNews();
        News news2 = altNews();
        assertEquals(news.getType(),"General");
        assertEquals(news2.getType(),"Entertainment");
    }

}