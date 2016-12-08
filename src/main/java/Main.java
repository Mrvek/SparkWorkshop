import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        getshit();
        get("/bar", (request, response) -> {
            return "Hello: ";


        });
    }

    private static void getshit() {
        final String[] ret = new String[1];
        get("/hello/:name", (request, response) -> {
            response.redirect("/bar"); // moved permanently
            return "Hello: " + request.params(":name");


        });

    }
}