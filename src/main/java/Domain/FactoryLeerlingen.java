package Domain;

import Domain.JSONS.JsonLMaster;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 07/12/2016.
 */
public class FactoryLeerlingen {
    private final JsonLMaster jsonMaster = new JsonLMaster();
    private static List<Leerling> users;

    public boolean setLeerling(String name, String ip, String port, Boolean ping) {
        for (Leerling L : users) {
            if (L.getName().equals(name)) {
                L.setIp(ip);
                L.setPort(port);
                L.setPing(ping);
                return true;
            }
        }return false;
    }

    public static List<Leerling> getUsers() {
        return users;
    }

    public static void setUsers(List<Leerling> users) {
        FactoryLeerlingen.users = users;
    }

    public static Leerling createLeerling(JSONObject object) {
        String name = (String) object.get("Name");
        Boolean result = (Boolean) object.get("Result");
        String ip = (String) object.get("Ip");
        String port = (String) object.get("Port");
        Boolean ping = (Boolean) object.get("Ping");
        Leerling l = new Leerling(name, result, ip, port, ping);
        return l;
    }

    public JSONObject getListInJSON() {
        Map<String, Boolean> RMap = new HashMap<>();
        for (Leerling L : users) {
            String name = L.getName();
            Boolean result = L.getResult();
            RMap.put(name, result);
        }
        System.out.print(RMap);
        JSONObject Result = jsonMaster.packJSON(RMap);
        System.out.print(Result);
        return Result;
    }

    public void UpdateFile() {
        jsonMaster.updateFile(users);
    }

    public Object getLeerling(String leerling) {
        for (Leerling L : users) {
            if (L.getName().equals(leerling)) {
                return L;
            }
        }
        return null;
    }
}
