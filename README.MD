# Conversor de Monedas en Java

Creamos un código de Conversor de Monedas, que utiliza una API de tasas de cambio para realizar conversiones entre diferentes monedas. Ahora les dejo una breve descripción de la misma

## Importaciones

Se importan las clases necesarias para trabajar con `Scanner`, `HttpClient`, `HttpRequest`, `HttpResponse`, `URI`, y `JsonObject` de la biblioteca `com.google.gson`.


### Variables de Configuración

Se define la `API_KEY` y la `BASE_URL` para acceder a la API de conversión de monedas. Si el codigo no llegase a funcionar, por favor dirijase a la pagina: https://www.exchangerate-api.com/ para crearse una cuenta, y luego obtengan una API_KEY gratuita que les da la pagina, reemplazen la API_KEY del programa por la suya!.

### Método principal `main`

- Inicia la ejecución del programa.
- Inicializa el cliente HTTP y el Scanner para la entrada del usuario.
- Muestra un mensaje de bienvenida al usuario y un menú de selección de moneda.
- Permite al usuario realizar múltiples conversiones mediante un bucle `while`.

### Lógica de Selección de Moneda

- Lee la opción seleccionada por el usuario.
- Asigna las monedas de origen y destino según la opción seleccionada.
- Si la opción es inválida (`7` para salir), se finaliza la ejecución del bucle.

### Proceso de Conversión

- Solicita al usuario ingresar el valor a convertir.
- Utiliza el método `convertCurrency` para obtener la tasa de cambio y realizar la conversión.
- Muestra el resultado de la conversión al usuario.

### Método `convertCurrency()`

- Construye la URL de la API con las monedas de origen y destino.
- Crea una solicitud HTTP (`HttpRequest`) para obtener la tasa de cambio.
- Envía la solicitud HTTP y procesa la respuesta JSON para obtener la tasa de cambio.
- Calcula y devuelve el monto convertido.


### Importaciones y API utilizada

- Se importan las clases necesarias para trabajar con `Scanner`, `HttpClient`, y objetos `HttpRequest` y `HttpResponse`.
- Se utiliza la API de conversión de monedas de `exchangerate-api.com` con una clave de API proporcionada.

### Lógica de Conversión de Monedas

- El usuario elige las opciones de conversión de moneda (dólar a otra moneda y viceversa).
- Se manejan las conversiones mediante el método `convertCurrency`.
- La conversión se realiza solicitando la tasa de cambio a través de la API y realizando los cálculos correspondientes.

### Método `convertCurrency`

- Este método utiliza la API de tasas de cambio para obtener la tasa de conversión entre dos monedas.
- Construye la URL de la API, realiza la solicitud HTTP y procesa la respuesta JSON para obtener la tasa de cambio.

## Ejecución del Programa

Para ejecutar y utilizar el Conversor de Monedas, sigue estos pasos:

1. Clona o descarga este repositorio con el código Java.
2. Abre el proyecto en un entorno de desarrollo de Java.
3. Ejecuta la clase `Main` para iniciar el programa.
4. Sigue las instrucciones en la consola para seleccionar las opciones de conversión y realizar conversiones de moneda.

IMPORTANTE: Asegúrate de tener una conexión a Internet activa para que el programa pueda acceder a la API de tasas de cambio.

¡Disfruta convirtiendo diferentes monedas con este Conversor de Monedas!