
// Client Side Program
import java.net.*;
import java.io.*;

class Client {
    public static void main(String[] args) {
        try {
            // Create a socket
            Socket client = new Socket("localhost", 9989);
            // get input stream
            BufferedReader in = new BufferedReader(new
            InputStreamReader(client.getInputStream()));
            // read time from server
            String time = in.readline();
            // printing time
            System.out.println(time);
            in.close(); // close input stream
            client.close(); // close socket
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

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
        catch (10Exception e) {
            System.out.println(e);
        }
    }
}