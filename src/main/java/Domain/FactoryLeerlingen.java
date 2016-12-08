package Domain;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mitchell on 07/12/2016.
 */
public class FactoryLeerlingen {
    private final JsonMaster jsonMaster = new JsonMaster();
    static List<Leerling> users;
    static {
        try {
            ArrayList<Leerling> gotten = JsonMaster.readList();
            System.out.print(gotten);
            if (!gotten.isEmpty()) {
                users = gotten;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean setleerling(String name, Boolean ping, String ip) {
        for (Leerling L : users) {
            if (L.getName().equals(name)) {
                L.setIp(ip);
                L.setPing(ping);
                return true;
            }
        }return false;
    }

    public static Leerling createLeerling(JSONObject object) {
        String name = (String) object.get("Name");
        Boolean result = (Boolean) object.get("Result");
        String ip = (String) object.get("Ip");
        Boolean ping = (Boolean) object.get("Ping");
        Leerling l = new Leerling(name, result, ip, ping);
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
