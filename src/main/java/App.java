import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
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



    }
}
