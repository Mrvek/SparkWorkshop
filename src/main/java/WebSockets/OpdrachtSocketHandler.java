package WebSockets;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@WebSocket
public class OpdrachtSocketHandler {

    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();

    @OnWebSocketConnect
    public void onConnect(Session user) throws Exception {
        sessions.add(user);
        SocketManager.setleerling("Mitchell van Ek");
        System.out.print("go further? ");
        user.setIdleTimeout(10000);
    }

    @OnWebSocketClose
    public void onClose(Session user, int statusCode, String reason) {
        sessions.remove(user);

    }

    @OnWebSocketMessage
    public void onMessage(Session user, String message) {
    }

    public void sendMessage(Object message, Session session) throws IOException {
        session.getRemote().sendString(String.valueOf(message));
    }
}