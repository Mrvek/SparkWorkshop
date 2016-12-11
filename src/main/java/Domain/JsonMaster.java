package Domain;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

 class JsonMaster {
	static private String userListPath = "src/main/java/UserList.json";

    JsonMaster() {
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
            FileWriter file = new FileWriter(userListPath);
            System.out.print(array.toJSONString());
            file.write(array.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    JSONObject packJSON(Map<String, Boolean> RMap) {
        JSONObject job = new JSONObject();

        for (String i : RMap.keySet()) {
            Boolean value = RMap.get(i);
            job.put(i, value);
        }
        return job;
    }

    static ArrayList<Leerling> readList() throws IOException, ParseException {
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