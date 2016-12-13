import Domain.*;
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
        AppBuilder.setup();
//        Configurations
        staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
        VelocityTemplateEngine.class.getSimpleName();

//        Routemanagement
        webSocket("/list", WebSocketHandler.class);


        webSocket("/ping", OpdrachtSocketHandler.class);

        get("/user/:name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String naam = req.params(":name");
            Leerling L = (Leerling) UserListHandler.getLeerling(naam);
            System.out.print(L.getName());
            if (L.getName().equals("mitchell")) {
                UserListHandler.updateLists();
            } else {
                L.setIp(req.ip());
            }
            model.put("name", req.params(":name"));
            model.put("ip", L.getIp());
            model.put("port", L.getPort());

            // The wm files are located under the resources directory
            return new ModelAndView(model, "hello.vm");
        }, new VelocityTemplateEngine());

        get("/user/:name/assignment", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String naam = req.params(":name");
            Leerling L = (Leerling) UserListHandler.getLeerling(naam);
            System.out.print(L.getName());
            if (L.getName().equals("mitchell")) {
                UserListHandler.updateLists();
            } else {
                L.setIp(req.ip());
            }


            // The wm files are located under the resources directory
            return new ModelAndView(model, "assignmentlist.vm");
        }, new VelocityTemplateEngine());

        get("/user/:name/assignment/:assignment", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String naam = req.params(":assignment");
            String leerling = req.params(":name");
            Leerling L = (Leerling) UserListHandler.getLeerling(leerling);
            Assignment A = AssignmentHandler.getAssignment(naam);
            System.out.print(A.getNaam());
            AssignmentCheck ac = new AssignmentCheck();
            ac.check(A, L);



            // The wm files are located under the resources directory
            return new ModelAndView(model, "assignmentlist.vm");
        }, new VelocityTemplateEngine());

//        TODO: new get for activating the check?
        




    }

}
