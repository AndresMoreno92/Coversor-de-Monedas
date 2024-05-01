
import java.util.Map;
import java.util.Set;

public class monedas {

    private String time_last_update_utc;

    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public void setConversionRates(Map<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    // Método para obtener solo los códigos de moneda
    public Set<String> getCodigosMoneda() {
        return conversion_rates.keySet();
    }
}