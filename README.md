# FIT Challenge Agustin Fila
- Trello: https://trello.com/b/dZx4mtlz/fit-challenge

**CONFIGURACION**

*BASE DE DATOS:*
- Para que se cree la base hay que crear una connexion en el MySQL Workbench con los siguientes datos: 
  -   Hostname: localhost
  -   Port: 3306
  -   username: root
  -   password: root
- Una vez creada la conexion crear un 'schema' con el nombre *fit_challenge*, en el caso de crearlo con otro nombre se puede configurar el backend para que apunte otro 'schema', en el archivo **src/main/resources/application.properties** definir los siguientes atributos:
```
spring.datasource.url=jdbc:mysql://localhost:3306/fit_challenge
spring.datasource.username=root
spring.datasource.password=root
```
- Script para crear un usuario: 
  - INSERT INTO 'fit_challenge'.'usuario' ('id', 'apellido', 'clave', 'mail', 'nombre', 'nombre_usuario') VALUES ('1', 'Fila', 'clave123', 'agusfila@gmail.com',    'Agustin', 'agusfila00');

*FRONTEND:*
  - En el archivo **proxy.conf.json** indicar el puerto en el que se levanta el backend (Por defecto: 8080)
``` 
{
  "/api/*": {
    "target": "http://localhost:8080",
    "secure": false,
    "logLevel": "debug"
  }
}
```
*BACKEND:*
- Si se llega al limite de llamadas que puede realizar el token de CoinApi, se puede modificar cambiando la variable *token* en el archivo **src/main/java/com/fit/Fila_Agustin_Challenge/coinapi/CoinApiSvc.java**:
```
public class CoinApiSvc {
    private static CoinApiSvc instancia = null;
    private static int maximaCantidadRegistrosDefault = 200;
    private static final String urlApi = "https://rest.coinapi.io/v1/";
    private static final String token = "B70DD534-777A-49AE-BE58-C46FF24F33CF";
    private Retrofit retrofit;
```
- Token Validos:
  - B70DD534-777A-49AE-BE58-C46FF24F33CF
  - 6DE078B1-427D-4EAF-87A7-C0490BE4FE21
