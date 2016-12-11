import Domain.FactoryLeerlingen;
import Domain.JsonLMaster;
import Domain.Leerling;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mitchell on 11/12/2016.
 */
public class AppBuilder {
    private static JsonLMaster JsonLMaster = new JsonLMaster();

    public static void setup() {
        try {
            ArrayList<Leerling> gotten = JsonLMaster.readList();
            System.out.print(gotten);
            if (!gotten.isEmpty()) {
                FactoryLeerlingen.setUsers(gotten);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
