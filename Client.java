import java.net.*;
import java.io.*;

class InvalidClientCommandException extends Exception {
    public InvalidClientCommandException(String str) {
        super(str);
    }
}

class Client {
    private static Socket client;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        System.out.println(getDate());
        System.out.println(getTime());
    }

    public static void startConnection(String ip, int port) throws IOException {
        client = new Socket(ip, port);
        out = new PrintWriter(client.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    public static String getDate() {
        try {
            startConnection("localhost", 9989);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(ServerCommands.GET_DATE.toString());
        String resp = null;
        try {
            resp = in.readLine();
            try {
                verifyValidCommand(resp);
            } catch (InvalidClientCommandException e) {
                e.printStackTrace();
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resp;
    }

    public static String getTime() {
        try {
            startConnection("localhost", 9989);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(ServerCommands.GET_TIME.toString());
        String resp = null;
        try {
            resp = in.readLine();
            try {
                verifyValidCommand(resp);
            } catch (InvalidClientCommandException e) {
                e.printStackTrace();
            }
            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }

    public static void verifyValidCommand(String serverResponse) throws InvalidClientCommandException {
        if (serverResponse.equals("invalid-command")) {
            throw new InvalidClientCommandException("Invalid command from client, must be either getTime or getData");
        }
    }
}