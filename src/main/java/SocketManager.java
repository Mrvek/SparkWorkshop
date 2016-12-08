import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by Mitchell on 08/12/2016.
 */
public class SocketManager {
    private static WebSocketHandler ListSocket = new WebSocketHandler();
    public static void updateList(JSONObject jsonObject) throws IOException {
        ListSocket.UpdateAll(jsonObject);

    }
}
