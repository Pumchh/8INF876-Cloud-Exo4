import java.io.File;
import java.net.Socket;

public class RequestProcessor implements Runnable {

    private HttpContext context;

    private void process() {
        HttpRequest request = context.getRequest();
        HttpResponse response = context.getResponse();

        String url = request.getUrl();

        if (url.startsWith("/")) {
            url = url.substring(1);
        }

        if (url.isEmpty()) {
            url = "index.html";
        }

        File file = new File("Serveur/src/public/" + url);

        if (file.exists() && file.isFile()) {
            response.ok("OK");
            response.sendFile("text/html", file.getPath());
        } else {
            response.notFound("Page not found");
            response.sendFile("text/html", "Serveur/src/public/404.html");
        }

        context.close();
    }

    public RequestProcessor(Socket socket) {
        context = new HttpContext(socket);
    }

    @Override
    public void run() {
        process();
    }
}
