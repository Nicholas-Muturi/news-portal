package dao;

import models.Department;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class Sql2oDeptDaoTest {
    private Sql2oDeptDao deptDao = new Sql2oDeptDao();

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    private Department newDept(){
        Department department = new Department("Producers","We the best");
        deptDao.add(department);
        return department;
    }

    @Test
    public void departmentAddedToDatabase(){
        Department department = newDept();
        System.out.println(department.getId());
        assertNotEquals(0,department.getId());
    }




}