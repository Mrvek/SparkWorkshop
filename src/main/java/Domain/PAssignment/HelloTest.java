package Domain.PAssignment;

/**
 * Created by Victor on 13/12/2016.
 */
import java.net.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Domain.PLeerling.Leerling;

public class HelloTest {
    //private String input;

    public HelloTest(Leerling leerling, int testnummer){
        String leerlingNaam = leerling.getName().replaceAll(" ", "%20");
        String leerlingVoorNaam = leerling.getName().substring(0, leerling.getName().indexOf(" "));
        String leerlingURL = "";
        if (testnummer == 1){
            leerlingURL = "http://" + leerling.getIp() + ":" + leerling.getPort() + "/hello";
        }else if (testnummer == 2){
            leerlingURL = "http://" + leerling.getIp() + ":" + leerling.getPort() + "/user/" + leerlingNaam;
        }
        try {
            URL fetch = new URL(leerlingURL);
            BufferedReader in = new BufferedReader(
            new InputStreamReader(fetch.openStream()));
            String inputLine;
            List<String> result = new ArrayList<String>();
            while ((inputLine = in.readLine()) != null) {
                result.add(inputLine);
                System.out.println(result);
            }
            in.close();
            if (testnummer == 1){
                if (!(leerlingVoorNaam.equals(result.get(0).substring(6)))){
                    throw new Exception();
                }
            }else if (testnummer == 2){
                if (!((String.valueOf(leerling.getRandom())).equals(result.get(0)))){
                    throw new Exception();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
