# fit_challenge_fila_agustin
Trello: https://trello.com/b/dZx4mtlz/fit-challenge

CONFIGURACION

BASE DE DATOS:
- Para que se cree la base hay que crear una connexion en el MySQL Workbench con los siguientes datos: 
  -   Hostname: localhost
  -   Port: 3306
  -   username: root
  -   password: root

- Script para crear un usuario: 
  - INSERT INTO 'fit_challenge'.'usuario' ('id', 'apellido', 'clave', 'mail', 'nombre', 'nombre_usuario') VALUES ('1', 'Fila', 'clave123', 'agusfila@gmail.com',    'Agustin', 'agusfila00');

FRONTEND:
  - En el archivo proxy.conf.json indicar el puerto en el que se levanta el backend (Por defecto: 8080)
  - ``` 
{
  "/api/*": {
    "target": "http://localhost:8080",
    "secure": false,
    "logLevel": "debug"
  }
}
```
