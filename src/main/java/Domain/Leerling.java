package Domain;

/**
 * Created by Mitchell on 08/12/2016.
 */
public class Leerling {
    private String name;
    private Boolean result;
    private String ip;
    private Boolean ping;

    public Leerling(String name, Boolean result, String ip, Boolean ping) {
        this.name = name;
        this.result = result;
        this.ip = ip;
        this.ping = ping;
    }

    public void setIp(String ip) {
        this.ip = ip;
        checkData();
    }

    public void setPing(Boolean ping) {
        this.ping = ping;
        checkData();
    }

    private void checkData() {
        if (ip  != null && ping == true) {
            result = true;
            LeerlingHandler.Update();
        }
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

    public Boolean getPing() {
        return ping;
    }
}
