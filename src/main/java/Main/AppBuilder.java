package Main;

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
    private static JsonLMaster JLM = new JsonLMaster();

    public static void setup() {
        try {
//            TODO: Finish  assignmentbuilder, may be hardcoded
            AssignmentHandler.createAssignment("assignment1", "maak een webserver die bij jouw poortnummer 'Hello JouwVoorNaam!' returned.");
            AssignmentHandler.createAssignment("assignment2", "laat je webserver jouw generated number terug returnen");
            AssignmentHandler.createAssignment("assignment3", "Maak een websocket op /ping en zorg ervoor dat hij elk bericht dat hij binnenkrijgt antwoord met 'pong'.");
            AssignmentHandler.createAssignment("assignment4", "Maak 2 websockets aan op /server en /front. Onze server stuurt berichten van iedereen door naar /server en deze moeten naar jouw front-end gaan met /front. Ook moet je zelf berichten kunnen sturen en naar /server kunnen sturen");

            ArrayList<Leerling> gotten = JLM.readList();
            System.out.print(gotten);
            if (!gotten.isEmpty()) {
                FactoryLeerlingen.setUsers(gotten);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
