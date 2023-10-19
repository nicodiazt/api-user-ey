

```markdown
# Prueba Técnica EY Octubre 2023

Esta aplicación permite realizar el registro de usuarios a través de un endpoint. A continuación, se describen los pasos para compilar y ejecutar la aplicación, así como una prueba del endpoint utilizando `curl`.

## Compilación y Ejecución

Para compilar y ejecutar la aplicación, seguir estos pasos:

1. Asegúrate de tener Gradle instalado en tu sistema.

2. Clona el repositorio de la aplicación:

   ```bash
   git clone https://github.com/nicodiazt/api-user-ey.git
   ```

3. Navega al directorio raíz del proyecto:

   ```bash
   cd api-user-ey
   ```

4. Ejecuta la compilación de la aplicación:

   ```bash
   gradle build
   ```

5. Una vez que la compilación sea exitosa, puedes ejecutar la aplicación con el siguiente comando:

   ```bash
   java -jar build/libs/user-api-1.0.0.jar
   ```
 
 
## Prueba del Endpoint

para probar el endpoint de registro utilizando `curl`:

```bash
curl --location 'http://localhost:8080/api/users/register' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.cl",
  "password": "Contrasena123",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "countrycode": "57"
    }
  ]
}'
```


## Documentación solicitada:

- `classDiagram.png`: Diagrama de clases generado con Mermaid.
- `sequenceDiagram.png`: Diagrama de secuencia generado con Mermaid.
- `schema.sql`: Estructura de la base de datos.


 

 