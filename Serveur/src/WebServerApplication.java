
public class WebServerApplication {

    public static void main(String[] args) {
        System.out.println("Starting web server...");
        WebServer webServer = new WebServer();
        webServer.run(80);

    }
}