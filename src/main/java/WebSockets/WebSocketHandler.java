package WebSockets;

import Domain.UserListHandler;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@WebSocket
public class WebSocketHandler {

    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        sessions.add(user);
        System.out.print("go further? ");
        user.setIdleTimeout(10000);
        sendMessage(UserListHandler.getList(), user);
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
    }

    void UpdateListOfAllSessions(JSONObject list) throws IOException {
        for (Session s : sessions) {
            s.getRemote().sendString(String.valueOf(list));
        }
    }
}