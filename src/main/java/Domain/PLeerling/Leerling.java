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
    private double random = 0.0;
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
        this.result = true;
        UserListHandler.Update();
    }

    public void setIp(String ip) {
        if (!(ip.isEmpty()) && this.ip.equals("0:0:0:0:0:0:0:1")) {
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
    public void setRandom(double random){
        this.random = random;
    }

    public void setResult(Boolean result) {
        this.result = result;
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

    public double getRandom() {
        return random;
    }

    public Boolean getPing() {
        return ping;
    }

    public void addCompletedAssignment(Assignment assignment) {
        doneAssignments.add(assignment);
    }

    public boolean checkassigmentallreadydone(Assignment assignment) {
        if (doneAssignments.contains(assignment)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Leerling{" +
                "name='" + name + '\'' +
                ", result=" + result +
                "\n\t ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", lastmessage='" + lastmessage + '\'' +
                "} \n";
    }
}
