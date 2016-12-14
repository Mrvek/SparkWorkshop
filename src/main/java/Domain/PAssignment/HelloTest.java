package Domain.PAssignment;

/**
 * Created by Victor on 13/12/2016.
 */
import java.net.*;
import java.io.*;
import Domain.PLeerling.Leerling;

public class HelloTest {
    private String input;

    public HelloTest(Leerling leerling){
        String leerlingNaam = leerling.getName().replaceAll(" ", "%20");
        String leerlingURL = "http://" + leerling.getIp() + ":" + leerling.getPort() + "/user/" + leerlingNaam;
        try {
            URL fetch = new URL(leerlingURL);
            BufferedReader in = new BufferedReader(
            new InputStreamReader(fetch.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(" afgemaakt door: " + inputLine);
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
