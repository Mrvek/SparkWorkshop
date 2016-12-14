package Domain.PLeerling;

import Domain.JSONS.JsonLMaster;
import WebSockets.SocketManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;

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

    public static Leerling getLeerling(String Leerling) {
        return FL.getLeerling(Leerling);
    }

    public static void updateLists() {
        JsonLMaster JLM = new JsonLMaster();
        ArrayList<Leerling> gotten;
        try {
            gotten = JLM.readList();
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

    public static Leerling getLeerlingByIp(InetSocketAddress remoteAddress) {
        return FL.getLeerlingByIp(remoteAddress);
    }
}
