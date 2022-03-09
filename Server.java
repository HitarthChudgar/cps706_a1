// Server Side Program
import java.net.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;



class Server {
    public static void main(String[] args) {

        ServerSocket server = null;
        try {
            server = new ServerSocket(9989);
            System.out.println("Socket Server is Running");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                // Create a server socket
                // accepting a connection
                assert server != null;
                Socket client = server.accept();
                System.out.println("Received Client Connection");
                // getting input stream
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String command = in.readLine();
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                if (command.equals(ServerCommands.GET_DATE.toString()) || command.equals(ServerCommands.GET_TIME.toString())) {
                    System.out.printf("Valid command: %s received from client\n", command);
                    // Get current time
                    Calendar c = new GregorianCalendar();
                    Date t = c. getTime();
                    DateFormat df;
                    if (command.equals(ServerCommands.GET_DATE.toString())) {
                        // Format as a date
                        df = new SimpleDateFormat("MM/dd/yy");
                    } else {
                        // Time
                        df = new SimpleDateFormat("HH:mm:ss");
                    }
                    // send appropriate message to client
                    out.println(df.format(t));

                } else {
                    out.println("invalid-command");
                    System.out.println("Invalid command received from client");
                }
                out.close();
                in.close();
                client.close();
            }
            // catch exception
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}