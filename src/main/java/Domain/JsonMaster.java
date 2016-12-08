package Domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonMaster {
    static private String path = "C:\\Users\\Mitchell\\ProjectWorkspace\\Java\\TestMavenSpark\\src\\main\\java\\Presentielijst.json";
    static private String userListPath = "C:\\Users\\Mitchell\\ProjectWorkspace\\Java\\TestMavenSpark\\src\\main\\java\\UserList.json";
    public JsonMaster() {
    }

    void updateFile(List<Leerling> users) {
        try {
            JSONArray array = new JSONArray();
            for (Leerling L : users) {
                JSONObject obj = new JSONObject();
                obj.put("Name", L.getName());
                obj.put("Result", L.getResult());
                obj.put("Ip", L.getIp());
                obj.put("Ping", L.getPing());
                array.add(obj);
            }
            FileWriter file = new FileWriter(getPath());
            System.out.print(array.toJSONString());
            file.write(array.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static Map<String, Boolean> getDataMap() throws IOException, ParseException {
        JSONParser pars = new JSONParser();
        JSONObject obj;

        obj = (JSONObject) pars.parse(new FileReader(getPath()));
        Map<String, Boolean> List = new HashMap<String, Boolean>();
        for (Object s : obj.keySet()) {
            String name = (String) s;
            Boolean value = (Boolean) obj.get(name);
            List.put(name, value);
        }
        System.out.print(obj.toJSONString());
        return List;
    }

    private static String getPath() {
        return path;
    }

    public JSONObject packJSON(Map<String, Boolean> RMap) {
        JSONObject job = new JSONObject();

        for (String i : RMap.keySet()) {
            Boolean value = RMap.get(i);
            job.put(i, value);
        }
        return job;
    }

    public static ArrayList<Leerling> readList() throws IOException, ParseException {
        ArrayList<Leerling> returnList = new ArrayList<>();
        JSONParser pars = new JSONParser();
        JSONArray array = (JSONArray) pars.parse(new FileReader(userListPath));
        for (Object o : array) {
            JSONObject object = (JSONObject) o;
            Leerling l = FactoryLeerlingen.createLeerling(object);
            returnList.add(l);
        }
        return returnList;
    }
}