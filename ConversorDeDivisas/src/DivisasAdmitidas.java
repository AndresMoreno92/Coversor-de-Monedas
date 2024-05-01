

import java.util.HashSet;
import java.util.Set;

public class DivisasAdmitidas {
    private static Set<String> monedaAdmitida;

    static {
        // Inicializar el conjunto de monedas admitidas
        monedaAdmitida = new HashSet<>();
        monedaAdmitida.add("COP");
        monedaAdmitida.add("MXN");
        monedaAdmitida.add("USD");
        monedaAdmitida.add("EUR");
        monedaAdmitida.add("GBP");
        monedaAdmitida.add("CLP");
        monedaAdmitida.add("ARS");
        monedaAdmitida.add("BOB");
        monedaAdmitida.add("PEN");
        monedaAdmitida.add("BRL");
        monedaAdmitida.add("CNY");
        monedaAdmitida.add("JPY");
    }

    public static boolean esMonedaAdmitida(String moneda) {
        return monedaAdmitida.contains(moneda);
    }

    public static String getNombreMoneda(String codigoMoneda) {
        switch (codigoMoneda) {

            case "COP": return "COP = Peso colombiano";
            case "MXN": return "MXN = Peso mexicano";
            case "USD": return "USD = Dólar estadounidense";
            case "EUR": return "EUR = Euro";
            case "GBP": return "GBP = Libra esterlina";
            case "CLP": return "CLP = Peso chileno";
            case "ARS": return "ARS = Peso argentino";
            case "BOB": return "BOB = Boliviano";
            case "PEN": return "PEN = Sol peruano";
            case "BRL": return "BRL = Real brasileño";
            case "CNY": return "CNY = Yuan chino";
            case "JPY": return "JPY = Yen japonés";
            default: return "Desconocido";
        }
    }

    public static void mostrarMonedasAdmitidas() {
        System.out.println("Monedas admitidas para conversión:");
        int index = 1;
        for (String moneda : monedaAdmitida) {
            System.out.println(index + ". " + getNombreMoneda(moneda));
            index++;
        }
    }
}

//Prueba para realizar la busqueda con numeros: fallo , buscar solucion
//  case "1": return "USD = Dólar estadounidense";
//  case "2": return "EUR = Euro";
//  case "3": return "GBP = Libra esterlina";
//  case "4": return "CLP = Peso chileno";
//  case "5": return "ARS = Peso argentino";
//  case "6": return "BOB = Boliviano";
//  case "7": return "PEN = Sol peruano";
//  case "8": return "BRL = Real brasileño";
//  case "9": return "COP = Peso colombiano";
//  case "10": return "MXN = Peso mexicano";
//  case "11": return "CNY = Yuan chino";
//  case "12": return "JPY = Yen japonés";
//default: return "Desconocido";