package Domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 08/12/2016.
 */
class Leerling {
    private String name;
    private List doneAssignments;
    private Boolean result;
    private String ip;
    private String port;
    private Boolean ping;    

    Leerling(String name, Boolean result, String ip, String port, Boolean ping) {
        this.name = name;
        this.doneAssignments = new ArrayList<Assignment>();
        this.result = result;
        this.ip = ip;
        this.port = port;
        this.ping = ping;
    }

    void setIp(String ip) {
        this.ip = ip;
        checkData();
    }
    void setPort(String port) {
        this.port = port;
        checkData();
    }
    void setPing(Boolean ping) {
        this.ping = ping;
        checkData();
    }

    private void checkData() {
        if (ip  != null && ping) {
            result = true;
            UserListHandler.Update();
        }
    }

    String getName() {
        return name;
    }

    Boolean getResult() {
        return result;
    }

    String getIp() {
        return ip;
    }
    String getPort() {
        return port;
    }
    Boolean getPing() {
        return ping;
    }
}
