package dao;

import models.News;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings("ConstantConditions")
public class Sql2oNewsDaoTest {
    private static Sql2oNewsDao newsDao = new Sql2oNewsDao();

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private News simpleNews(){
        News news = new News("Simple News","Nothing to report");
        newsDao.add(news);
        return news;
    }
    private News altNews(){
        News news = new News("New Album","Kanye drop new album","Entertainment");
        newsDao.add(news);
        return news;
    }
    private News altNews2(){
        News news = new News("New Album Yet Again","Kanye drop new album again","entertainment");
        newsDao.add(news);
        return news;
    }

    @Test
    public void newsGetsSavedToDb(){
        News news = simpleNews();
        assertNotEquals(0,news.getId());
    }



}