package Main;

import Domain.JSONS.IJsonMaster;
import Domain.JSONS.JsonAssignment;
import Domain.JSONS.JsonLMaster;
import Domain.PAssignment.AssignmentHandler;
import Domain.PLeerling.FactoryLeerlingen;
import Domain.PLeerling.Leerling;
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
//            TODO: Finish  assignmentbuilder, may be hardcoded
            AssignmentHandler.createAssignment("assignment1", "maak een webserver die bij jouw poortnummer 'Hello World!' returned.");
            AssignmentHandler.createAssignment("assignment2", "laat je webserver gebruik maken van index.html zodra je de website bezoekt");
            AssignmentHandler.createAssignment("assignment3", "Maak een websocket op /ping en zorg ervoor dat hij elk bericht dat hij binnenkrijgt antwoord met 'pong'.");
            AssignmentHandler.createAssignment("assignment4", "Maak 2 websockets aan op /server en /front. Onze server stuurt berichten van iedereen door naar /server en deze moeten naar jouw front-end gaan met /front. Ook moet je zelf berichten kunnen sturen en naar /server kunnen sturen");
// ArrayList<Assignment> assignments = JsonAssignment.readList();
//            System.out.print(assignments);
//            if (!assignments.isEmpty()) {
//                FactoryAssignments.setAssignmentArrayList(assignments);
//            }
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
