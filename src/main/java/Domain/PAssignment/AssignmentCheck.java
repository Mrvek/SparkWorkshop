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
        boolean result = false;
        if (leerling.checkassigmentallreadydone(a)) {
            result = true;
        }else {
            switch (a.getNaam()) {
                case "assignment1":
                    try {
                        HelloTest test = new HelloTest(leerling);
                        leerling.addCompletedAssignment(a);
                        result = true;
                    } catch (Exception e) {
                        System.out.print(leerling.getName() + "heeft niet voldaan aan assignment 1\n");
                    }
                    break;
                case "assignment2":
                    result = true;
                    break;
                case "assignment3":
                    try {
                        PingTest test = new PingTest(new URI("ws://" + leerling.getIp() + ":" + leerling.getPort() + "/ping"));
                        leerling.addCompletedAssignment(a);
                        test.sendMessage("Assignment voltooid!");
                        result = true;
                    } catch (URISyntaxException e) {
                        System.out.print(leerling.getName() + "heeft niet voldaan aan assignment 3\n");
                    }
                    break;
                case "assignment4":
                    if (!(leerling.getLastmessage().isEmpty() || leerling.getLastmessage() == null)) {
                        leerling.addCompletedAssignment(a);
                        leerling.setResult(true);
                        result = true;
                    } else {
                        System.out.print(leerling.getName() + "heeft niet voldaan aan assignment 4\n");
                    }
                    break;
            }
        }
       return result;
    }
}
