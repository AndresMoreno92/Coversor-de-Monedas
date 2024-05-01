import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ConversorMoneda conversorMoneda = new ConversorMoneda();
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        ArrayList<String> resumenConversiones = new ArrayList<>();

        System.out.println("Bienvenido a la casa de cambio ");
        System.out.println("Tasa de cambio actualizada");
        System.out.println("*************************************");

        // Muestra las monedas admitidas
        DivisasAdmitidas.mostrarMonedasAdmitidas();

        while(continuar) {
            System.out.println("\nPor favor ingrese las iniciales de la moneda que desea convertir(MAYUSCULAS):");

            String monedaInicial = entrada.nextLine();

            // Validacion si la moneda de origen es admitida
            if (!DivisasAdmitidas.esMonedaAdmitida(monedaInicial)) {
                System.out.println("La moneda especificada no es admitida.");
                continue; // Solicitar de nuevo la moneda
            }

            // Obtener el objeto Moneda
            monedas monedaData = conversorMoneda.ingresoUsuario(monedaInicial);

            // Verificar si "Moneda" tiene tasa de conversión
            if (monedaData.getConversionRates() == null) {
                System.out.println("No se encontraron tasas de conversión para la moneda especificada.");
                return; // Salir del programa
            }

            System.out.println("\nPor favor, ingrese las inicales de la moneda de destino(MAYUSCULAS)");
            String monedaDestino = entrada.nextLine();

            if (!DivisasAdmitidas.esMonedaAdmitida(monedaDestino)) {
                System.out.println("La moneda especificada no es admitida.");
                continue;
            }

            System.out.println("\nIngrese la cantidad de dinero a convertir:");
            double cantidad = entrada.nextDouble();

            double cantidadConvertida = conversorMoneda.convertirMoneda(cantidad, monedaInicial, monedaDestino);
            DecimalFormat formato = new DecimalFormat("#.##");
            String resultadoFormateado = formato.format(cantidadConvertida);

            System.out.println("\n" + cantidad + " " + monedaInicial + " equivale a " + resultadoFormateado + " " + monedaDestino);

            entrada.nextLine();

            resumenConversiones.add( cantidad + " " + monedaInicial + " equivale a " + resultadoFormateado + " " + monedaDestino +".");
            // Ofrecer opción de continuar o salir
            System.out.println("\n¿Desea realizar otra conversión? 1 para sí, 0 para salir.");
            String opcion = entrada.nextLine();
            if(!opcion.equalsIgnoreCase("1")){
                continuar = false;
            }
        }

        // Mostrar el historial de conversion
        System.out.println("\nResumen de la solicitud en esta sesión:");
        for (String consulta : resumenConversiones) {
            System.out.println("~ " + consulta);
        }

        System.out.println("\nGracias por utilizar nuestro conversor.\n");

        entrada.close();

    }
}