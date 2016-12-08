import spark.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static spark.Spark.init;
import static spark.Spark.staticFileLocation;
import static spark.Spark.webSocket;

/**
 * Created by Mitchell on 07/12/2016.
 */
public class Start {
    public static void main(String[] args) {
        staticFileLocation("/public"); //index.html is served at localhost:4567 (default port)
        webSocket("/list", WebSocketHandler.class);
        init();
    }
}
