package dao;

import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {
    public Sql2oNewsDao(){}

    @Override
    public void add(News news) {
        String checkedType = crossCheckDepartments(news.getType());

        String sql = "INSERT INTO news (title,description,type) VALUES (:title,:description,:type)";
        try (Connection con = DB.sql2o.open()) {
            int id = (int) con.createQuery(sql,true)
                    .addParameter("title",news.getTitle())
                    .addParameter("description",news.getDescription())
                    .addParameter("type",checkedType)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public String crossCheckDepartments(String deptName) {
        String sql = "SELECT name from departments;";
        try (Connection con = DB.sql2o.open()) {
            List<String> allNames = con.createQuery(sql)
                    .executeAndFetch(String.class);

            for(String name:allNames){
                if(deptName.equalsIgnoreCase(name)){
                    deptName = name;
                }
            }
        }
        return deptName;
    }


    @Override
    public News findById(int id) {
        return null;
    }

    @Override
    public List<News> allNews() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteAll() {

    }
}
