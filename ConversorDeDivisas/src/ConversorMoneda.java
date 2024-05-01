
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConversorMoneda {

    // obtiene la tasa de conversión entre monedas
    public double obtenerTasaConversion(String monedaInicial, String monedaDestino) {
        monedas datosMoneda = ingresoUsuario(monedaInicial);
        return datosMoneda.getConversionRates().get(monedaDestino);
    }

    // realiza la conversión de una cantidad de una moneda a otra
    public double convertirMoneda(double cantidad, String monedaOrigen, String monedaDestino) {
        double tasaConversion = obtenerTasaConversion(monedaOrigen, monedaDestino);
        return cantidad * tasaConversion;
    }

    //API
    public monedas ingresoUsuario(String moneda) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/3ed3522528a9784ed0f5c0dc/latest/" + moneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            Gson gson = new Gson();
            monedas monedaData = gson.fromJson(responseBody, monedas.class);

            // Verificar si el mapa de tasas de conversión se ha inicializado correctamente
            if (monedaData.getConversionRates() == null) {
                throw new RuntimeException("El objeto Moneda devuelto no tiene tasas de conversión.");
            }

            return monedaData;
        } catch (Exception e) {
            throw new RuntimeException("Moneda no encontrada");
        }
    }

}