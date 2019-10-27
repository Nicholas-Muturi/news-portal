package dao;

import models.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oUserDaoTest {
    private static Sql2oUserDao userDao = new Sql2oUserDao();

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private User newUser(){
        User user = new User("Kanye West","Manager","Artist","Def Jam");
        userDao.add(user);
        return user;
    }

    @Test
    public void userSavedToDatabase(){
        User user = newUser();
        assertNotEquals(0,user.getId());
    }




}