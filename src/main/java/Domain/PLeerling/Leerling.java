package Domain.PLeerling;

import Domain.PAssignment.Assignment;

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

    public String getLastmessage() {
        return lastmessage;
    }

    public void setLastmessage(String lastmessage) {
        this.lastmessage = lastmessage;
    }

    public void setIp(String ip) {
        if (!(ip.isEmpty() || ip == null)) {
            this.ip = ip;
        }
        UserListHandler.Update();
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPing(Boolean ping) {
        this.ping = ping;
        UserListHandler.Update();
    }

    public void setResult(Boolean result) {
        this.result = result;
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
