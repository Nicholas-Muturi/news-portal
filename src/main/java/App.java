import static spark.Spark.*;

import com.google.gson.Gson;
import models.*;
import dao.Sql2oNewsDao;
import dao.Sql2oDeptDao;
import dao.Sql2oUserDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Sql2oDeptDao deptDao = new Sql2oDeptDao();
        Sql2oUserDao userDao = new Sql2oUserDao();
        Sql2oNewsDao newsDao = new Sql2oNewsDao();
        Gson gson = new Gson();

        /*-----------HEROKU CONFIG------------*/
        ProcessBuilder process = new ProcessBuilder();
        int port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);
        /*------------------------------------*/


        /*-----------------DEPARTMENT-------------------*/
        get("/departments","application/json",(request, response) -> {
            return gson.toJson(deptDao.allDepartments());
        });

        post("/departments/new","application/json",(request, response) -> {
            Department department = gson.fromJson(request.body(),Department.class);
            deptDao.add(department);
            response.status(201);
            return gson.toJson(department);
        });

        get("/department/:deptId/details","application/json",(request, response) -> {
            int deptId = Integer.parseInt(request.params("deptId"));
            return gson.toJson(deptDao.findById(deptId));
        });

        post("/department/:deptId/users/new","application/json",(request, response) -> {
            int deptId = Integer.parseInt(request.params("deptId"));
            Department department = deptDao.findById(deptId);

            if(department != null){
                User employee = gson.fromJson(request.body(),User.class);
                employee.setDepartment(department.getName());
                userDao.add(employee);
                deptDao.addUserToDept(department,employee);
                response.status(201);
                return gson.toJson(employee);
            } else {
                throw new ApiException(404,"Department not found");
            }
        });

        get("/department/:deptId/users","application/json",(request, response) -> {
            int deptId = Integer.parseInt(request.params("deptId"));
            return gson.toJson(deptDao.allDepartmentEmployees(deptId));
        });

        get("/department/:deptId/users/:userId/details","application/json",(request, response) -> {
            int userId = Integer.parseInt(request.params("userId"));
            User foundUser = userDao.findById(userId);

            if (foundUser != null) {
                return gson.toJson(foundUser);
            }
            else {
                throw new ApiException(404,"User not found");
            }
        });

        get("/department/:deptId/news","application/json",(request, response) -> {
            int deptId = Integer.parseInt(request.params("deptId"));
            return gson.toJson(deptDao.allDepartmentNews(deptId));
        });




        /*-----------------END DEPARTMENT-------------------*/


        /*-----------------USERS-------------------*/
        get("/users","application/json",(request, response) -> {
            return gson.toJson(userDao.allUsers());
        });

        get("/users/:userId/details","application/json",(request, response) -> {
            int userId = Integer.parseInt(request.params("userId"));
            return gson.toJson(userDao.findById(userId));
        });
        /*-----------------END USERS-------------------*/


        /*-----------------NEWS-------------------*/
        get("/news","application/json",(request, response) -> {
            return gson.toJson(newsDao.allNews());
        });
        get("/news/:newsId/details","application/json",(request, response) -> {
            int newsId = Integer.parseInt(request.params("newsId"));
            return gson.toJson(newsDao.findById(newsId));
        });
        /*-----------------END NEWS-------------------*/

        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
