package Domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 08/12/2016.
 */
public class Leerling {
    private String name;
    private List doneAssignments;
    private Boolean result;
    private String ip;
    private String port;
    private Boolean ping;
    public String lastmessage;

    public Leerling(String name, Boolean result, String ip, String port, Boolean ping) {
        this.name = name;
        this.doneAssignments = new ArrayList<Assignment>();
        this.result = result;
        this.ip = ip;
        this.port = port;
        this.ping = ping;
    }

    public void setIp(String ip) {
        if (!(ip.isEmpty() || ip == null)) {
            this.ip = ip;
        }
            checkData();
    }

    public void setPort(String port) {
        this.port = port;
        checkData();
    }

    public void setPing(Boolean ping) {
        this.ping = ping;
        checkData();
    }

    private void checkData() {
        if (ip != null && ping) {
            result = true;
        }
            UserListHandler.Update();
    }

    public String getName() {
        return name;
    }

    public Boolean getResult() {
        return result;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    public Boolean getPing() {
        return ping;
    }

    public void addCompletedAssignment(Assignment assignment) {
        doneAssignments.add(assignment);
    }
}
