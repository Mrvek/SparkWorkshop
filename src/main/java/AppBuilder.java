import Domain.Assignment;
import Domain.FactoryAssignments;
import Domain.FactoryLeerlingen;
import Domain.JSONS.IJsonMaster;
import Domain.JSONS.JsonAssignment;
import Domain.JSONS.JsonLMaster;
import Domain.Leerling;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mitchell on 11/12/2016.
 */
public class AppBuilder {
    private static IJsonMaster JsonLMaster = new JsonLMaster();
    private static IJsonMaster JsonAssignment = new JsonAssignment();

    public static void setup() {
        try {
            ArrayList<Assignment> assignments = JsonAssignment.readList();
            System.out.print(assignments);
            if (!assignments.isEmpty()) {
                FactoryAssignments.setAssignmentArrayList(assignments);
            }
            ArrayList<Leerling> gotten = JsonLMaster.readList();
            System.out.print(gotten);
            if (!gotten.isEmpty()) {
                FactoryLeerlingen.setUsers(gotten);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
