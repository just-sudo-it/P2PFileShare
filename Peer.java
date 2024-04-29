import java.io.*;
import java.net.*;

public class Peer {
    private String host;
    private int port;

    public Peer(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void startClient() {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            // Example: Register to Tracker
            Request registerRequest = new Request("REGISTER", "username", "password", "192.168.1.1", 5000);
            out.writeObject(registerRequest);

            // Receive response from Tracker
            Response response = (Response) in.readObject();
            System.out.println("Response from Tracker: " + response.getMessage());

            // Further actions based on response...

        } catch (Exception e) {
            System.err.println("Error in client operation: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8000;  // Tracker's port
        try {
            Peer peer = new Peer(host, port);
            peer.startClient();
        } catch (IOException e) {
            System.err.println("Error starting Peer: " + e.getMessage());
        }
    }
}
