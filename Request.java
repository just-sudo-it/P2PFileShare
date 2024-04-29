class Request implements Serializable {
    private String type;
    private String username;
    private String password;
    private String ip;
    private int port;

    public Request(String type, String username, String password, String ip, int port) {
        this.type = type;
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
}
