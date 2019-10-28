package dao;

import models.News;
import java.util.List;

public interface NewsDao {
    //create
    void add(News news);
    void addNewsToDepartment(News news);

    //read
    News findById(int id);
    List<News> allNews();

    //update

    //delete
    void deleteById(int id);
    void deleteAll();
}
