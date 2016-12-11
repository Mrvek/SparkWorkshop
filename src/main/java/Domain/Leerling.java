package Domain;

/**
 * Created by Mitchell on 08/12/2016.
 */
class Leerling {
    private String name;
    private Boolean result;
    private String ip;
    private Boolean ping;

    Leerling(String name, Boolean result, String ip, Boolean ping) {
        this.name = name;
        this.result = result;
        this.ip = ip;
        this.ping = ping;
    }

    void setIp(String ip) {
        this.ip = ip;
        checkData();
    }

    void setPing(Boolean ping) {
        this.ping = ping;
        checkData();
    }

    private void checkData() {
        if (ip  != null && ping) {
            result = true;
            
        }
        UserListHandler.Update();
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

    Boolean getPing() {
        return ping;
    }
}
