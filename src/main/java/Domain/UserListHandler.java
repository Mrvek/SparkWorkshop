package Domain;

import WebSockets.SocketManager;
import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by Mitchell on 08/12/2016.
 */
public class UserListHandler {
    private static FactoryLeerlingen FL = new FactoryLeerlingen();


    static void setleerling(String name, Boolean ping, String ip) {
        FL.setleerling(name, ping, ip);
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
