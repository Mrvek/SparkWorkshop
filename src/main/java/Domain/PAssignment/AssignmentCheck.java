package Domain.PAssignment;

import Domain.PLeerling.Leerling;

import java.net.URI;
import java.net.URISyntaxException;//import spark.Session;

/**
 * Created by Mitchell on 08/12/2016.
 */
public class AssignmentCheck {

    public boolean check(Assignment a, Leerling leerling) {
//        TODO: check all assignments
        switch (a.getNaam()) {
            case "assignment1":

                try {
                    HelloTest test = new HelloTest(leerling);
                    leerling.addCompletedAssignment(a);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case "assignment2":
                break;
            case "assignment3":
                try {
                    PingTest test = new PingTest(new URI("ws://" + leerling.getIp() + ":" + leerling.getPort() + "/ping"));
                    leerling.addCompletedAssignment(a);
                    return true;
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                break;
            case "assignment4":
                if (!(leerling.getLastmessage().isEmpty() || leerling.getLastmessage() == null)) {
                    leerling.addCompletedAssignment(a);
                    return true;
                }
                break;
            default: return false;
        }
        return false;
    }
}
