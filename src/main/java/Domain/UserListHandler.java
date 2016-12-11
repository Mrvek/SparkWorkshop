package Domain;

import WebSockets.SocketManager;
import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by Mitchell on 08/12/2016.
 */

// Controller voor factory leerlingen - enige die factory mag benaderen.


public class UserListHandler {
    private static FactoryLeerlingen FL = new FactoryLeerlingen();


    static void setleerling(String name, String ip, String port, Boolean ping) {
        FL.setLeerling(name, port, ip, ping);
    }

    static void Update() {
        FL.UpdateFile();
        JSONObject userlist = FL.getListInJSON();
        try {
            SocketManager.updateList(userlist);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getList() {
        return FL.getListInJSON();
    }

    public static Object getLeerling(String Leerling) {
        return FL.getLeerling(Leerling);
    }
}
