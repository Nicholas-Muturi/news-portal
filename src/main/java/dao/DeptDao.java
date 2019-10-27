package dao;

import models.Department;
import models.News;
import models.User;

import java.util.List;

public interface DeptDao {
    //create
    void add(Department department);

    //read
    Department findById(int id);
    List<Department> allDepartments();
    List<User> allDepartmentEmployees();
    List<News> allDepartmentNews();

    //update


    //delete
    void deleteDepartmentById(int id);
    void deleteEmployeeById(int id);
    void deleteNewsById(int id);
    void deleteAll();
}
