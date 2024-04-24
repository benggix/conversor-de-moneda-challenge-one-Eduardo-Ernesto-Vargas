// importaciones necesarias para trabajar con el scanner y el Http Client.
// Agregamos las demàs importaciones para hacer peticiones y mandar respuestas Http.
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.Scanner;
import com.google.gson.*;

// Definicion de la clase principal Main.
public class Main {
  // configuracion de la API_KEY y la base de la url para la API de conversion de monedas.
  private static final String API_KEY = "fb3ce509ccd9335766e95df5";
  private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

  // Metodo principal main que inicia la ejecucion del programa.
  public static void main(String[] args) {
    // Inicialización del cliente HTTP y el Scanner para la entrada del usuario.
    HttpClient client = HttpClient.newHttpClient();
    Scanner scanner = new Scanner(System.in);
    // Mensaje de bienvenida al usuario.
    System.out.println("Bienvenido al Conversor de Monedas");
    // Variable para controlar la ejecución del bucle while para que no se nos cree un bucle infinito.
    boolean continuar = true;
    // Bucle principal que permite al usuario realizar múltiples conversiones.
    while (continuar) {
      // Mostramos el menú de selección de moneda al usuario, para que elija las opciones.
      System.out.println("Seleccione la moneda original:");
      System.out.println("1) Dólar =>> Peso argentino");
      System.out.println("2) Peso argentino =>> Dólar");
      System.out.println("3) Dólar =>> Real brasileño");
      System.out.println("4) Real brasileño =>> Dólar");
      System.out.println("5) Dólar =>> Peso colombiano");
      System.out.println("6) Peso colombiano =>> Dólar");
      System.out.println("7) Salir");
      System.out.print("Elija una opción: ");
      // Leemos la opción seleccionada por el usuario.
      int opcion = scanner.nextInt();
      // Evaluamos la opción seleccionada por el usuario.
      if (opcion == 7) {
        continuar = false;
        continue;
      }
      // Variables para almacenar las monedas de origen y destino.
      String fromCurrency = "";
      String toCurrency = "";
      // Asignamos las monedas de origen y destino según la opción seleccionada por el usuario.
      switch (opcion) {
        case 1:
          fromCurrency = "USD";
          toCurrency = "ARS";
          break;
        case 2:
          fromCurrency = "ARS";
          toCurrency = "USD";
          break;
        case 3:
          fromCurrency = "USD";
          toCurrency = "BRL";
          break;
        case 4:
          fromCurrency = "BRL";
          toCurrency = "USD";
          break;
        case 5:
          fromCurrency = "USD";
          toCurrency = "COP";
          break;
        case 6:
          fromCurrency = "COP";
          toCurrency = "USD";
          break;
        default:
          System.out.println("Opción inválida");
          continuar = false; // Si la opción es inválida, salimos del bucle while.
          break;
      }
      // Si la opción seleccionada es inválida y no debe continuar con la ejecución, regresando al inicio del bucle.
      if (!continuar) {
        continue;
      }
      // Solicitamos al usuario que ingrese el valor a convertir.
      System.out.print("Ingrese el valor que desea convertir: ");
      double amount = scanner.nextDouble();

      try {
        // Intentamos convertir la moneda utilizando el método convertCurrency.
        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount, client);
        // Mostramos el resultado de la conversión al usuario.
        System.out.println(amount + " " + fromCurrency + " es igual a " + convertedAmount + " " + toCurrency);
      } catch (Exception e) {
        // Capturamos y manejamos cualquier excepción que ocurra durante la conversión de moneda.
        System.out.println("Error al convertir moneda: " + e.getMessage());
      }
    }
    // Cerramos el Scanner al finalizar el programa.
    scanner.close();
  }
  // Método para convertir la moneda utilizando la API de tasas de cambio.
  public static double convertCurrency(String fromCurrency, String toCurrency, double amount, HttpClient client) throws Exception {
    // Construimos la URL de la API con las monedas de origen y destino.
    String endpoint = BASE_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;
    // Creamos una solicitud HTTP para obtener la tasa de cambio.
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .build();
    // Enviamos la solicitud HTTP y obtenemos la respuesta.
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    // Analizamos la respuesta JSON para obtener la tasa de cambio.
    JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
    double exchangeRate = jsonResponse.get("conversion_rate").getAsDouble();
    // Calculamos y devolvemos el monto convertido.
    return amount * exchangeRate;
  }
}