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

        static class HomeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Urban Hatch Farms Online Store</title>
                    <style>
                        body { font-family: Arial, sans-serif; background: #f4f7f6; margin: 0; padding: 20px; color: #333; }
                        .container { max-width: 800px; margin: auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }
                        h1 { color: #2c3e50; text-align: center; }
                        .batch-card { background: #eef2f3; padding: 15px; margin: 10px 0; border-radius: 5px; border-left: 5px solid #27ae60; }
                        button { background: #27ae60; color: white; border: none; padding: 10px 15px; border-radius: 4px; cursor: pointer; }
                        button:hover { background: #219653; }
                    </style>
                </head>
                <body>
                    <div class="container">
                    <h1>🐔 Urban Hatch Farms Online Store</h1>
                        <p style="text-align: center;">Welcome! Browse our live farm stock below:</p>
                        <div id="stock-list">Loading inventory...</div>
                    </div>
                    <script>
                        fetch('/api/batches')
                            .then(response => response.json())
                            .then(data => {
                                const container = document.getElementById('stock-list');
                                if (data.length === 0) {
                                    container.innerHTML = '<p>No stock currently available.</p>';
                                    return;
                                }
                                container.innerHTML = data.map(b => `
                                    <div class="batch-card">
                                        <h3>\${b.breed} (ID: \${b.ID})</h3>
                                        <p>Available Birds: <b>\${b.quantityAvailable}</b> | Price per bird: <b>$\${b.price}</b> | Weight: \${b.weight}kg</p>
                                    </div>
                                `).join('');
                            });
                    </script>
                </body>
                </html>
                """;

    }
}