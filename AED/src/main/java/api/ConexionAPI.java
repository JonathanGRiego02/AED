/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexionAPI {
    public static void main(String[] args) throws IOException {
        // URL de la API para generar 10 usuarios
        String apiUrl = "https://randomuser.me/api/?results=10&gender=female";
        String response = fetchDataFromAPI(apiUrl);

// Parsear el JSON
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray results = jsonResponse.getJSONArray("results");

// Mostrar información de cada usuario
        for (int i = 0; i < results.length(); i++) {
            JSONObject user = results.getJSONObject(i);
            System.out.println("Usuario " + (i + 1) + ":");
            System.out.println("Nombre: " + user.getJSONObject("name").getString("first") + " " + user.getJSONObject("name").getString("last"));
            System.out.println("Género: " + user.getString("gender"));
            System.out.println("Email: " + user.getString("email"));
            System.out.println("Ciudad: " + user.getJSONObject("location").getString("city"));
            System.out.println("País: " + user.getJSONObject("location").getString("country"));
            System.out.println("--------------------------------------------------");
        }
    }

    private static String fetchDataFromAPI(String apiUrl) throws IOException {
        // URL de la API

        // Crear una conexión a la URL
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // Leer la respuesta de la API
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        String s_response = response.toString();
        return s_response;
    }
}