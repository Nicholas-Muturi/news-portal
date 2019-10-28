import static spark.Spark.*;

import com.google.gson.Gson;
import models.*;
import dao.Sql2oNewsDao;
import dao.Sql2oDeptDao;
import dao.Sql2oUserDao;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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
            int idToFind = Integer.parseInt(request.params("deptId"));
            return gson.toJson(deptDao.findById(idToFind));
        });


        //FILTERS
        after((req, res) ->{
            res.type("application/json");
        });
    }
}
