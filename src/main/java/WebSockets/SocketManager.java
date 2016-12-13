package WebSockets;

import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by Mitchell on 08/12/2016.
 */
public class SocketManager {
    private static WebSocketHandler ListSocket = new WebSocketHandler();
    private static OpdrachtSocketHandler OpdrachtSocket = new OpdrachtSocketHandler();


    public static void updateList(JSONObject jsonObject) throws IOException {
        ListSocket.UpdateListOfAllSessions(jsonObject);
    }

    /*Manages Domain.PLeerling.FactoryLeerlingen too because of small system*/

}
