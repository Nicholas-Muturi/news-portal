package dao;

import models.Department;
import models.News;
import models.User;

import java.util.List;

public class Sql2oDeptDao implements DeptDao {

    @Override
    public void add(Department department) {

    }

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Department> allDepartments() {
        return null;
    }

    @Override
    public List<User> allDepartmentEmployees() {
        return null;
    }

    @Override
    public List<News> allDepartmentNews() {
        return null;
    }

    @Override
    public void deleteDepartmentById(int id) {

    }

    @Override
    public void deleteEmployeeById(int id) {

    }

    @Override
    public void deleteNewsById(int id) {

    }

    @Override
    public void deleteAll() {

    }
}
