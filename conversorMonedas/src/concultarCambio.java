import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class concultarCambio {

    double consultaDeCambio(String monedaOrg, String monedaCam){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5faab274a1a8bde7c73d37f1/latest/"+monedaOrg);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            return conversionRates.get(monedaCam).getAsDouble();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
