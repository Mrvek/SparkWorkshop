package WebSockets;

import Domain.PLeerling.Leerling;
import Domain.PLeerling.UserListHandler;
import org.eclipse.jetty.security.PropertyUserStore;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Mitchell on 13/12/2016.
 */

@WebSocket
public class ChatSocketHandler {
    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        sessions.add(user);
        System.out.print("Chatconnection succesfull: " + user);
        user.setIdleTimeout(3600000);
        Leerling L = UserListHandler.getLeerlingByIp(user.getRemoteAddress());
        if (L != null) {
            JSONObject O = new JSONObject();
            O.put("name", "System");
            O.put("Message", (L.getName() + "has connected"));
        }
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        sessions.remove(user);
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        try {
//            TODO: set message as lastmessage of the user
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(message);
            JSONObject O = (JSONObject) obj;
            String name = (String) O.get("name");
            String M = (String) O.get("Message");
            Leerling L = UserListHandler.getLeerling(name);
            if (L.getIp().equals(user.getRemoteAddress())) {
                SendMessage(message);
            }
            System.out.print(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    void SendMessage(String message) throws IOException {
        for (Session s : sessions) {
            s.getRemote().sendString(message);
        }
    }
}
