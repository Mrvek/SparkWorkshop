package WebSockets;

import Domain.PLeerling.UserListHandler;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Mitchell on 13/12/2016.
 */
public class ChatSocketHandler {
    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        sessions.add(user);
        System.out.print("Chatconnection succesfull: " + user);
        user.setIdleTimeout(10000);
    }

    private void sendMessage(JSONObject list, Session session) throws IOException {
        session.getRemote().sendString(String.valueOf(list));
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        sessions.remove(user);
    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
        try {
//            TODO: set message as lastmessage of the user
            SendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void SendMessage(String message) throws IOException {
        for (Session s : sessions) {
            s.getRemote().sendString(message);
        }
    }
}
