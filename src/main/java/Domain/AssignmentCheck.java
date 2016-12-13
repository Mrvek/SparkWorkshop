package Domain;

import java.net.URI;
import java.net.URISyntaxException;//import spark.Session;

/**
 * Created by Mitchell on 08/12/2016.
 */
public class AssignmentCheck {

    public void check(Assignment a, Leerling leerling) {
//        TODO: check all assignments
        switch (a.getNaam()){
            case "assignment1":
                break;
            case "assignment2":
                break;
            case "assignment3":
                try {
                    PingTest test = new PingTest(new URI("ws://" + leerling.getIp() + ":" + leerling.getPort() + "/ping"));
                    leerling.addCompletedAssignment(a);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                break;
            case "assignment4":
                break;

        }
    }
}
