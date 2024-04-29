import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

public class Tracker {
    private ServerSocket serverSocket;
    private ConcurrentHashMap<String, PeerInfo> peerInfoMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ConcurrentHashMap<String, FileInfo>> filesAvailable = new ConcurrentHashMap<>();

    public Tracker(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Tracker is running on port: " + port);
    }

    public void start() {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Error in Tracker start: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try (ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
                 ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream())) {

                Request request = (Request) input.readObject();
                switch (request.getType()) {
                    case "REGISTER":
                        handleRegister(request, output);
                        break;
                    case "LOGIN":
                        handleLogin(request, output);
                        break;
                    case "LOGOUT":
                        handleLogout(request, output);
                        break;
                    case "INFORM":
                        handleInform(request, output);
                        break;
                    case "QUERY":
                        handleQuery(request, output);
                        break;
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error handling client: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing socket: " + e.getMessage());
                }
            }
        }

        private void handleRegister(Request request, ObjectOutputStream output) throws IOException {
            String username = request.getUsername();
            if (peerInfoMap.containsKey(username)) {
                output.writeObject(new Response("ERROR", "Username already exists."));
            } else {
                PeerInfo newPeer = new PeerInfo(username, request.getIp(), request.getPort());
                peerInfoMap.put(username, newPeer);
                output.writeObject(new Response("SUCCESS", "Registered successfully."));
            }
        }

        private void handleLogin(Request request, ObjectOutputStream output) throws IOException {
            String username = request.getUsername();
            String password = request.getPassword();  // Assuming passwords are managed correctly
            PeerInfo peer = peerInfoMap.get(username);
            if (peer != null && peer.password.equals(password)) {
                output.writeObject(new Response("SUCCESS", "Login successful."));
            } else {
                output.writeObject(new Response("ERROR", "Login failed."));
            }
        }

        private void handleLogout(Request request, ObjectOutputStream output) throws IOException {
            String username = request.getUsername();
            if (peerInfoMap.containsKey(username)) {
                peerInfoMap.remove(username);
                output.writeObject(new Response("SUCCESS", "Logout successful."));
            } else {
                output.writeObject(new Response("ERROR", "Logout failed."));
            }
        }

        private void handleInform(Request request, ObjectOutputStream output) throws IOException {
            // Implement how peers inform the tracker about their files
        }

        private void handleQuery(Request request, ObjectOutputStream output) throws IOException {
            // Handle file query operations
        }
    }

    public static void main(String[] args) {
        int port = 8000;  // Default port for Tracker
        try {
            Tracker tracker = new Tracker(port);
            tracker.start();
        } catch (IOException e) {
            System.err.println("Failed to start Tracker: " + e.getMessage());
        }
    }
}
