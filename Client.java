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
            String time = in.readLine();
            // printing time
            System.out.println(time);
            in.close(); // close input stream
            client.close(); // close socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}