package app;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.*;
import domain.*;
import repository.*;
import service.*;

public class WebServer {
    public static void main(String[] args) throws IOException {
        int port = 7474;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        FarmRepository repository = new FarmRepository();
        FarmService service = new FarmService(repository);

        server.createContext("/", new HomeHandler()); // Endpoint for home page
        server.createContext("/batches", new BatchHandler(service)); // Endpoint for batches

        server.setExecutor(null); // creates a default executor
        server.start();

        System.out.println("Server started on port " + port);

        
    }
}