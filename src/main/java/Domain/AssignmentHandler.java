package Domain;

import java.util.ArrayList;

/**
 * Created by Mitchell on 12/12/2016.
 */
public class AssignmentHandler {
    private static FactoryAssignments AS = new FactoryAssignments();
    public static Assignment getAssignment(String naam) {
        ArrayList<Assignment> assignments =  AS.getAssignmentArrayList();
        for (Assignment a : assignments) {
            if (a.getNaam().equals(naam)) {
                return a;
            }
        }
        return null;
    }

    public static void createAssignment(String title, String description) {
        AS.createAssignment(title, description);
    }
}
