import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mitchell on 07/12/2016.
 */
public class FactoryLeerlingen {
    static private String path = "C:\\Users\\Mitchell\\ProjectWorkspace\\Java\\TestMavenSpark\\src\\main\\java\\Presentielijst.json";
    static Map<String, Boolean> leerlingen = new HashMap<>();
    static {
        try {
            Map<String, Boolean> Data = getDataMap();
            if (!Data.isEmpty()) {
                leerlingen = Data;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        leerlingen.put("Mitchell van Ek", false);
        System.out.print("M= " + leerlingen.get("Mitchell van Ek") + "\n");
    }

    static void setleerling(String L) {
        System.out.print("We check for the value: " + L + "\n");
        for (String i : leerlingen.keySet()) {
            if (i.equals(L)) {
                leerlingen.replace(i, true);
                System.out.print("yes! " + i + leerlingen.get(i) + "\n");
                updateFile();
                try {
                    SocketManager.updateList(packJSON());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void updateFile() {
        int changements = 0;
        try {
            Map<String, Boolean> data = getDataMap();
            for (String s : data.keySet()) {
                if (data.get(s) == false) {
                    Boolean user = leerlingen.getOrDefault(s, false);
                    if (user == true) {
                        leerlingen.put(s, true);
                        changements++;
                    }
                }
            }
            System.out.print(changements);
            if (changements > 0) {
                JSONObject obj = new JSONObject();
                for (String s : leerlingen.keySet()) {
                    Boolean value = leerlingen.get(s);
                    obj.put(s, value);
                }
                FileWriter file = new FileWriter(path);
                System.out.print(obj.toJSONString());
                file.write(obj.toJSONString());
                file.flush();
                file.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private static Map<String, Boolean> getDataMap() throws IOException, ParseException {
        JSONParser pars = new JSONParser();
        JSONObject obj = null;

            obj = (JSONObject) pars.parse(new FileReader(path));
            Map<String, Boolean> List = new HashMap<>();
            for (Object s : obj.keySet()) {
                String name = (String) s;
                Boolean value = (Boolean) obj.get(name);
                List.put(name, value);
            }
            System.out.print(obj.toJSONString());
        return List;
    }



    private FactoryLeerlingen(){}
    

    public static JSONObject packJSON() {
        JSONObject job = new JSONObject();

        for (String i : leerlingen.keySet()) {
            Boolean value = leerlingen.get(i);
            job.put(i, value);
        }
        return job;
    }
}
