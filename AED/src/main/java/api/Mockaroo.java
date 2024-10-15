package api;

import java.net.URI;
import java.net.URISyntaxException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Mockaroo {

    public static void main(String[] args) throws URISyntaxException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        String url = "https://my.api.mockaroo.com/Medicina.json?key=f8c65350";

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = null;  // Declarar la variable fuera del try-catch
        try {
            response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                System.out.println("Error en la solicitud: " + response);
                return;
            }

            if (response.body() != null) {
                String jsonString = response.body().string();
                JSONArray jsonArray = new JSONArray(jsonString);

                int elementosAImprimir = Math.min(10, jsonArray.length());
                for (int i = 0; i < elementosAImprimir; i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    System.out.println("Elemento " + (i + 1) + ": " + jsonObject.toString(4));
                }
            } else {
                System.out.println("El cuerpo de la respuesta es nulo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                response.close();  // Cerrar manualmente la respuesta
            }
        }
    }
}
