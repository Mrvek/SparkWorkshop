package Domain.JSONS;

import Domain.PLeerling.FactoryLeerlingen;
import Domain.PLeerling.Leerling;
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

 public class JsonLMaster implements IJsonMaster {
//     TODO: fixed port?
	static private String userListPath = "src/main/java/UserList.json";

     @Override
     public void updateFile(List objects) {
        try {
            List<Leerling> users = (List<Leerling>) objects;
            JSONArray array = new JSONArray();
            for (Leerling L : users) {
                JSONObject obj = new JSONObject();
                obj.put("Name", L.getName());
                obj.put("Result", L.getResult());
                obj.put("Ip", L.getIp());
                obj.put("Port", L.getPort());
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

    public JSONObject packJSON(Map<String, Boolean> RMap) {
        JSONObject job = new JSONObject();

        for (String i : RMap.keySet()) {
            Boolean value = RMap.get(i);
            job.put(i, value);
        }
        return job;
    }
     @Override
    public ArrayList readList() throws IOException, ParseException {
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