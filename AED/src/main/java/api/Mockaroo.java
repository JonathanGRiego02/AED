package api;

import java.net.URI;
import java.net.URISyntaxException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Duration;

public class Mockaroo {

    public static void main(String[] args) throws URISyntaxException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://my.api.mockaroo.com/Medicina.json?key=f8c65350";  // Agregar el punto y coma

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {  // Asegurarse de que el cuerpo de la respuesta no sea nulo
                String jsonString = response.body().string();  // Convertir a String el cuerpo de la respuesta

                // Parsear el JSON en un JSONArray
                JSONArray jsonArray = new JSONArray(jsonString);

                // Iterar sobre los primeros 10 elementos o hasta el tamaño máximo del array
                int elementosAImprimir = Math.min(10, jsonArray.length());
                for (int i = 0; i < elementosAImprimir; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    System.out.println("Elemento " + (i + 1) + ": " + jsonObject.toString(4));  // Imprimir con formato bonito (4 espacios)
                }
            } else {
                System.out.println("El cuerpo de la respuesta es nulo.");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Imprimir la excepción
        }
    }
}
