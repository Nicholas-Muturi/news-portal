package dao;

import models.Department;
import org.junit.Rule;

import static org.junit.Assert.*;

public class Sql2oDeptDaoTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private Department newDept(){
        return new Department("Producers","We the best");
    }


}