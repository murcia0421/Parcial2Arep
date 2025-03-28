package com.example.arep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/")
public class RedirectController {

    private static final String USER_AGENT = "Mozilla/5.0";

    @GetMapping("/")
    public String handleRequest(@RequestParam String path) {
        try {
            return redirectRequest(path);
        } catch (IOException e) {
            e.printStackTrace();
            return "{\"error\":\"Error al procesar la solicitud\"}";
        }
    }

    private String redirectRequest(String path) throws IOException {
        String targetUrl;

        if (path.startsWith("/linearsearch")) {
            targetUrl = "http://localhost:8081" + path;
        } else if (path.startsWith("/binarysearch")) {
            targetUrl = "http://localhost:8082" + path;
        } else {
            return "{\"error\":\"Ruta no válida\"}";
        }

        URL url = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                return response.toString();
            }
        } else {
            return "{\"error\":\"Error al consultar el servidor\"}";
        }
    }
}


