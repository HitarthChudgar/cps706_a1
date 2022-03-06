// Server Side Program
import java.net.*;
import java.io.*;
import java.util.*;

class Server {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(9989);
            // accepting a connection
            Socket client = server.accept();
            // getting input stream
            PrintWriter out = new
                    PrintWriter(client.getOutputStream(), true);
            // getting current time
            Calendar c = new GregorianCalendar();
            Date t = c. getTime();
            // send time to client
            out.println(t);
            out.close();// close output stream
            client.close();// close socket
            server.close();// close server socket
        }
        // catch exception
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}