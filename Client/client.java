import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) {
        String website = "";
        String page = "";
        int port = 80;
        
        System.out.println("Choose a website (Example: example.com/path): ");
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            website = consoleReader.readLine();
        } catch (IOException e) {
            System.out.println("Error reading input");
            e.printStackTrace();
            return;
        }

        String[] websiteSplit = website.split("/");
        String host = websiteSplit[0];

        for (int i = 1; i < websiteSplit.length; i++) {
            page += "/" + websiteSplit[i];
        }
        if (page.isEmpty()) {
            page = "/";
        }
        System.out.println("\n\n\n");

        try (Socket socket = new Socket(host, port)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("GET " + page + " HTTP/1.1");
            writer.println("Host: " + host);
            writer.println("Connection: close");
            writer.println();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("The website is unreachable");
            e.printStackTrace();
        }
    }
}
