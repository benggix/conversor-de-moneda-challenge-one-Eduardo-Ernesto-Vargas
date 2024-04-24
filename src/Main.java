// IMPORTACONES NECESARIOS PARA TRABAHAR CON SCANNER Y EL HTTP CLIENTE.
import java.net.http.HttpClient;
import java.util.Scanner;

public class Main {
  // CONFIGURAMOS NUESTRA API_KEY Y LA BASE URL.
  private static final String API_KEY = "fb3ce509ccd9335766e95df5";
  private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

  // iNICIALIZAREMOS EL CLIENTE HTTP, SCANNER PARA LA ENTRADA DEL USUARIO, CREAREMOS UN BUCLE WHILE Y EVALUAREMOS LAS RESPUESTA SEGUN LA OPCION ELEJIDA POR EL USUARIO CON EL SWITCH SEGUN LOS CASOS.
  public static void main(String[] args) {
    HttpClient client = HttpClient.newHttpClient();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Bienvenido al Conversor de Monedas");
    boolean continuar = true;
    while (continuar) {
      System.out.println("Seleccione la moneda original:");
      System.out.println("1) Dólar =>> Peso argentino");
      System.out.println("2) Peso argentino =>> Dólar");
      System.out.println("3) Dólar =>> Real brasileño");
      System.out.println("4) Real brasileño =>> Dólar");
      System.out.println("5) Dólar =>> Peso colombiano");
      System.out.println("6) Peso colombiano =>> Dólar");
      System.out.println("7) Salir");
      System.out.print("Elija una opción: ");
      int opcion = scanner.nextInt();

      if (opcion == 7) {
        continuar = false;
        continue;
      }

      String fromCurrency = "";
      String toCurrency = "";
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
          continuar = false;
          break;
      }

      if (!continuar) {
        continue;
      }

      }
    }
  }

