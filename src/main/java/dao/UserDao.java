package dao;

import models.User;
import java.util.List;

public interface UserDao {
    //create
    void add(User user);

    //read
    User findById(int id);
    List<User> allUsers();

    //update


    //delete
    void deleteById(int id);
    void deleteAll();

}
