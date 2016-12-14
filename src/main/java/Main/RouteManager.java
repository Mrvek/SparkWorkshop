package Main;

import Domain.PAssignment.Assignment;
import Domain.PAssignment.AssignmentCheck;
import Domain.PAssignment.AssignmentHandler;
import Domain.PLeerling.Leerling;
import Domain.PLeerling.UserListHandler;
import WebSockets.ChatSocketHandler;
import WebSockets.OpdrachtSocketHandler;
import WebSockets.WebSocketHandler;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

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
        webSocket("/chat", ChatSocketHandler.class);


        webSocket("/ping", OpdrachtSocketHandler.class);

        get("/user/:name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String naam = req.params(":name");
            Leerling L = (Leerling) UserListHandler.getLeerling(naam);
            System.out.print(L.getName());
            if (L.getName().equals("Mitchell van Ek")) {
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
            if (L.getName().equals("Mitchell van Ek")) {
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
            System.out.print(":" + L + ";" + A + ":\n");
            model.put("title", A.getNaam());
            model.put("description", A.getDescription());
            model.put("done", "");



            // The wm files are located under the resources directory
            return new ModelAndView(model, "assignmentdetails.vm");
        }, new VelocityTemplateEngine());


        get("/user/:name/assignment/:assignment/check", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String naam = req.params(":assignment");
            String leerling = req.params(":name");
            Leerling L = (Leerling) UserListHandler.getLeerling(leerling);
            Assignment A = AssignmentHandler.getAssignment(naam);
            System.out.print(A.getNaam());
            AssignmentCheck ac = new AssignmentCheck();
            boolean check = ac.check(A, L);

            model.put("title", A.getNaam());
            model.put("description", A.getDescription());
            if (check) {
                model.put("done", "Finished");
            }else {
                model.put("done", "Sorry, try again!");
            }




            // The wm files are located under the resources directory
            return new ModelAndView(model, "assignmentlist.vm");
        }, new VelocityTemplateEngine());





    }

}
