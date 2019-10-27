package dao;

import models.News;
import org.junit.Rule;

import static org.junit.Assert.*;

public class Sql2oNewsDaoTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private News simpleNews(){
        return new News("Simple News","Nothing to report");
    }

    private News altNews(){
        return new News("New Album","Kanye drop new album","Entertainment");
    }



}