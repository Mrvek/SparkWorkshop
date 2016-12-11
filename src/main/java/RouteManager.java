import WebSockets.OpdrachtSocketHandler;
import WebSockets.WebSocketHandler;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by Mitchell on 07/12/2016.
 */
public class RouteManager {
    public static void main(String[] args) {
//        Configurations
        staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
        VelocityTemplateEngine.class.getSimpleName();

//        Routemanagement
        webSocket("/list", WebSocketHandler.class);


        webSocket("/opdracht", OpdrachtSocketHandler.class);

        get("/user", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("hello", "Velocity World");


            // The wm files are located under the resources directory
            return new ModelAndView(model, "hello.vm");
        }, new VelocityTemplateEngine());

        try {
            Test.testingTest();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
